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
import com.lexy.foodapp.model.Allmenu;

import java.util.List;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.AllMenuViewHolder> {
    private Context context;
    private List<Allmenu> allMenuList;

    public AllMenuAdapter(Context context, List<Allmenu> allMenuList) {
        this.context = context;
        this.allMenuList = allMenuList;
    }

    @NonNull
    @Override
    public AllMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false);

        return new AllMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllMenuViewHolder holder, int position) {
        holder.allMenuName.setText(allMenuList.get(position).getName());
        holder.allMenuCharges.setText(allMenuList.get(position).getDeliveryCharges());
        holder.allMenuNote.setText(allMenuList.get(position).getNote());
        holder.allMenuPrice.setText(allMenuList.get(position).getPrice());
        holder.allMenuRating.setText(allMenuList.get(position).getRating());
        holder.allMenuTime.setText(allMenuList.get(position).getDeliveryTime());
        Glide.with(context).load(allMenuList.get(position).getImageUrl()).into(holder.allMenuImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDetails.class);
                intent.putExtra("name", allMenuList.get(position).getName());
                intent.putExtra("price", allMenuList.get(position).getPrice());
                intent.putExtra("rating", allMenuList.get(position).getRating());
                intent.putExtra("image", allMenuList.get(position).getImageUrl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allMenuList.size();
    }


    public static class AllMenuViewHolder extends RecyclerView.ViewHolder{
        TextView allMenuName, allMenuNote, allMenuRating, allMenuTime, allMenuCharges, allMenuPrice;
        ImageView allMenuImage;

        public AllMenuViewHolder(@NonNull View itemView) {
            super(itemView);

            allMenuName = itemView.findViewById(R.id.all_menu_name);
            allMenuNote = itemView.findViewById(R.id.all_menu_note);
            allMenuRating = itemView.findViewById(R.id.all_menu_rating);
            allMenuTime = itemView.findViewById(R.id.all_menu_deliverytime);
            allMenuCharges = itemView.findViewById(R.id.all_menu_delivery_charge);
            allMenuPrice = itemView.findViewById(R.id.all_menu_price);
            allMenuImage = itemView.findViewById(R.id.all_menu_image);
        }
    }
}
