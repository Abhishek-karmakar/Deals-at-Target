package com.abhishek.TargetDeals.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abhishek.TargetDeals.R;
import com.abhishek.TargetDeals.activity.DailogActivity;
import com.abhishek.TargetDeals.activity.ItemDetailsActivity;
import com.abhishek.TargetDeals.model.TargetDealModel;
import com.abhishek.TargetDeals.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by akarmakar.
 * @Description : The DatalistAdapter class binds the data from the webservice to the model required for that service.
 *
 */

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.MyViewHolder> {
    Context context;
    ArrayList<TargetDealModel> dataModels;

    public DataListAdapter(Context context, ArrayList<TargetDealModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @Override
    public DataListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataListAdapter.MyViewHolder holder, int position) {

        Picasso.with(context).load(dataModels.get(position)
                .getImage())
                .fit()
                .placeholder(R.drawable.targetico)
                .error(R.drawable.placeholder)
                .into(holder.imgPhoto);
        holder.imgPhoto.setTag(dataModels.get(position).getImage());
        holder.tvTitle.setText(dataModels.get(position).getTitle());
        holder.tvDesc.setText(dataModels.get(position).getDescription());
        holder.tvPrice.setText(dataModels.get(position).getPrice());
        holder.tvShip.setText("ship");
        holder.tvAisle.setText(dataModels.get(position).getAisle());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvDesc, tvPrice, tvShip, tvAisle;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.imgPhoto);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            tvShip = (TextView) itemView.findViewById(R.id.tvShip);
            tvAisle = (TextView) itemView.findViewById(R.id.tvAisle);

            // making the onclick listeners

            imgPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String imagePath = (String) v.getTag();
                    Intent i = new Intent(new Intent(context, DailogActivity.class));
                    i.putExtra(Constants.IMAGE_PATH, imagePath);
                    context.startActivity(i);
                }
            });

            tvShip.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Shiping action performed", Toast.LENGTH_SHORT).show();
                }
            });


            tvAisle.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Present on Aisle" + tvAisle.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });



            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    TargetDealModel targetDealModel = dataModels.get(getLayoutPosition());
                    Intent i = new Intent(new Intent(context, ItemDetailsActivity.class));
                    i.putExtra(Constants.ITEM_DETAILS, targetDealModel);
                    context.startActivity(i);
                }
            });
        }
    }
}
