package com.abhishek.TargetDeals.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.abhishek.TargetDeals.R;
import com.abhishek.TargetDeals.utils.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailogActivity extends Activity {
    @BindView(R.id.imgPreview)
    ImageView imgPriview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dailog);
        ButterKnife.bind(this);
        String imagePAth = "";
        if (getIntent() != null) {
            imagePAth = getIntent().getStringExtra(Constants.IMAGE_PATH);
            Picasso.with(this).load(imagePAth).into(imgPriview);
        } else {

        }
    }

}
