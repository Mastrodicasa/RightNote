package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context ctx, List<Product> productList) {
        mCtx = ctx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card, null);
        ProductViewHolder holder = new ProductViewHolder(view, mCtx);
        return holder;
    }

    @Override
    public void onBindViewHolder (ProductViewHolder holder, final int position){
        Product product = productList.get(position);

        holder.textViewTitle.setText(product.getTitle());
      //  holder.textViewDesc.setText(product.getShortdesc());
       // holder.textViewRating.setText(String.valueOf(product.getRating()));
        // holder.textViewPrice.setText(String.valueOf(product.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));


    }

    @Override
    public int getItemCount(){
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textViewTitle;
       // TextView textViewDesc, textViewRating, textViewPrice;
        Context mCtx;

        public ProductViewHolder (View itemView, Context ctx){
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            //textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
           // textViewRating = itemView.findViewById(R.id.textViewRating);
          //  textViewPrice = itemView.findViewById(R.id.textViewPrice);
            this.mCtx = ctx;
        }

        @Override
        public void onClick (View v){

            switch(this.getPosition()+1){
                case 1:{
                    Intent course=new Intent(this.mCtx, CourseLevel1Activity.class);
                    this.mCtx.startActivity(course);
                    break;}
                case 2:
                {
                    Intent course = new Intent(this.mCtx, CourseLevel2Activity.class);
                    this.mCtx.startActivity(course);
                    break;
                }
                case 3:
                {
                    Intent course = new Intent(this.mCtx, CourseLevel3Activity.class);
                    this.mCtx.startActivity(course);
                    break;
                }
            }

        }
    }
}
