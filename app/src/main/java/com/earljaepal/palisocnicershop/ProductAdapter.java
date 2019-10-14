package com.earljaepal.palisocnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.earljaepal.palisocnicershop.model.ItemShop;

import java.util.LinkedList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.
        ProductViewHolder> {

    private Context mContext;
    private LinkedList<ItemShop> mItemList;
    private LayoutInflater mInflater;

    public ProductAdapter(Context context,
                           LinkedList<ItemShop> itemList) {
        mInflater = LayoutInflater.from(context);
        this.mItemList= itemList;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card_content,
                viewGroup, false);
        return new ProductViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder productViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder { ;
        final ProductAdapter mAdapter;
        //ItemShop item;

        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            this.mAdapter = adapter;
            //this.item = item;
        }
    }
}