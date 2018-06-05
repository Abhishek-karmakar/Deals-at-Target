package com.abhishek.TargetDeals.activity;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abhishek.TargetDeals.R;
import com.abhishek.TargetDeals.model.TargetDealModel;
import com.abhishek.TargetDeals.utils.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
@Author : Akarmakar
@Desc : The class to show the detail of the item present in the list.
using butterKnife to Bind elements to show data.

ToDO : Later convert this to MVP

 */
public class ItemDetailsActivity extends AppCompatActivity {
    @BindView(R.id.imgItemImage)
    CardView imgItemImage;

    @BindView(R.id.tvItemName)
    TextView tvItemName;

    @BindView(R.id.tvItemDescription)
    TextView tvItemDescription;

    @BindView(R.id.tvSalePrice)
    TextView tvSalePrice;

    @BindView(R.id.tvPrice)
    TextView tvPrice;

    @BindView(R.id.imgDeailsView)
    ImageView imgDeailsView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        ButterKnife.bind(this);

        tvItemDescription.setMovementMethod(new ScrollingMovementMethod());

        if (getIntent() != null) {
            TargetDealModel targetDealModel = (TargetDealModel) getIntent().getSerializableExtra(Constants.ITEM_DETAILS);
            Picasso.with(this).load(targetDealModel.getImage().toString())
                    .placeholder(R.drawable.targetico)
                    .error(R.drawable.placeholder)
                    .into(imgDeailsView);
            tvItemName.setText(targetDealModel.getTitle());
            tvItemDescription.setText(targetDealModel.getDescription());
            tvSalePrice.setText(targetDealModel.getSalePrice());
            tvPrice.setText("Reg: " + targetDealModel.getPrice());
            tvPrice.setPaintFlags(tvPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            finish();
        }


    }
}
