package com.abhishek.TargetDeals.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.abhishek.TargetDeals.R;
import com.abhishek.TargetDeals.utils.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
@Author : Akarmakar
@Desc : Image preview class shows the image when you click on the image.
It can be used to show other information regarding the image quickly.
 */

public class ImagePreviewActivity extends AppCompatActivity {
    @BindView(R.id.imgPreview)
    ImageView imgPreview;

    @BindView(R.id.root_layout)
    View rootLayout;

    public static final String EXTRA_CIRCULAR_REVEAL_X = "EXTRA_CIRCULAR_REVEAL_X";
    public static final String EXTRA_CIRCULAR_REVEAL_Y = "EXTRA_CIRCULAR_REVEAL_Y";
    public static final String POSITION = "POSITION";


    private int revealX;
    private int revealY;
    private int position;
    String imagePAth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.activity_image_preview);
        ButterKnife.bind(this);

        final Intent intent = getIntent();
        if (intent != null) {
            imagePAth = getIntent().getStringExtra(Constants.IMAGE_PATH);
        } else {

        }

        if (savedInstanceState == null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
                intent.hasExtra(EXTRA_CIRCULAR_REVEAL_X) &&
                intent.hasExtra(EXTRA_CIRCULAR_REVEAL_Y)) {
            rootLayout.setVisibility(View.INVISIBLE);

            Picasso.with(this).load(imagePAth).
                    placeholder(R.drawable.placeholder).
                    error(R.drawable.placeholder).
                    into(imgPreview);

            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        revealX = (int) (rootLayout.getX() + rootLayout.getWidth() / 2);
                        revealY = (int) (rootLayout.getY() + rootLayout.getHeight() / 2);
                        revealActivity(revealX, revealY);
                        rootLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        } else {
            rootLayout.setVisibility(View.VISIBLE);
            Picasso.with(this).load(imagePAth).into(imgPreview);
        }
    }

    protected void revealActivity(int x, int y) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()) * 1.1);

            // create the animator for this view (the start radius is zero)
            Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, x, y, 0, finalRadius);
            circularReveal.setDuration(500);
            circularReveal.setInterpolator(new AccelerateInterpolator());

            // make the view visible and start the animation
            rootLayout.setVisibility(View.VISIBLE);
            circularReveal.start();
        } else {
            finish();
        }
    }

    @Override
    protected void onStop() {
        unRevealActivity();
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        unRevealActivity();
        super.onBackPressed();
    }

    public void closeScreen() {
        unRevealActivity();
    }

    protected void unRevealActivity() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            finish();
        } else {
            float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()) * 1.1);
            Animator circularReveal = ViewAnimationUtils.createCircularReveal(
                    rootLayout, revealX, revealY, finalRadius, 0);

            circularReveal.setDuration(500);
            circularReveal.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    rootLayout.setVisibility(View.INVISIBLE);
                    finish();
                }
            });
            circularReveal.start();
        }
    }

}
