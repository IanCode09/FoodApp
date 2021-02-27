package com.lexy.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lexy.foodapp.FoodDetails;
import com.lexy.foodapp.R;
import com.lexy.foodapp.model.Popular;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private Context context;
    private List<Popular> popularList;

    public PopularAdapter(Context context, List<Popular> popularList) {
        this.context = context;
        this.popularList = popularList;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_recycler_items, parent, false);

        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        holder.popularName.setText(popularList.get(position).getName());
        Glide.with(context).load(popularList.get(position).getImageUrl()).into(holder.popularImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDetails.class);
                intent.putExtra("name", popularList.get(position).getName());
                intent.putExtra("price", popularList.get(position).getPrice());
                intent.putExtra("rating", popularList.get(position).getRating());
                intent.putExtra("image", popularList.get(position).getImageUrl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {
        ImageView popularImage;
        TextView popularName;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            popularImage = itemView.findViewById(R.id.popular_image);
            popularName = itemView.findViewById(R.id.popular_name);
        }
    }

}
