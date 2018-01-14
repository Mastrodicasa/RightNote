package com.example.user.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bertrand on 08-01-18.
 */

public class ProductAdapterInfo extends RecyclerView.Adapter<ProductAdapterInfo.ProductInfoViewHolder> {

    private Context mCtx;
    private List<ProductInfo> productList;

    public ProductAdapterInfo(Context ctx, List<ProductInfo> productList) {
        mCtx = ctx;
        this.productList = productList;
    }

    @Override
    public ProductInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_info, null);
        ProductInfoViewHolder holder = new ProductInfoViewHolder(view, mCtx);
        return holder;
    }

    @Override
    public void onBindViewHolder (ProductInfoViewHolder holder, final int position){
        ProductInfo product = productList.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDesc.setText(product.getShortdesc());
        // holder.textViewRating.setText(String.valueOf(product.getRating()));
        // holder.textViewPrice.setText(String.valueOf(product.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount(){
        return productList.size();
    }

    class ProductInfoViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDesc;
        // textViewRating, textViewPrice;
        Context mCtx;

        public ProductInfoViewHolder (View itemView, Context ctx){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewInfo);
            textViewTitle = itemView.findViewById(R.id.textViewTitleInfo);
            textViewDesc = itemView.findViewById(R.id.textViewShortDescInfo);
            // textViewRating = itemView.findViewById(R.id.textViewRating);
            //  textViewPrice = itemView.findViewById(R.id.textViewPrice);
            this.mCtx = ctx;
        }


    }
}
