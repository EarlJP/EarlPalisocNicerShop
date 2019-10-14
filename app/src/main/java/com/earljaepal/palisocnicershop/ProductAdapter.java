package com.earljaepal.palisocnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.earljaepal.palisocnicershop.model.ItemShop;

import java.util.ArrayList;
import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.
        ProductViewHolder> {

    private static final String LOG_TAG =
            ProductAdapter.class.getSimpleName();

    private ArrayList<ItemShop> mItemList;
    private LayoutInflater mInflater;

    public ProductAdapter(Context context,
                          ArrayList<ItemShop> itemList) {
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
        ItemShop chosenItem = mItemList.get(i);
        productViewHolder.title.setText(chosenItem.getmItemTitle());
        productViewHolder.image.setImageResource(chosenItem.getmItemImage());
        productViewHolder.price.setText(chosenItem.getmItemPrice());
        productViewHolder.description.setText(chosenItem.getmItemDescription());
        productViewHolder.quantityTitle.setText(chosenItem.getmQuantityTitle());
        productViewHolder.removeButton.setText(chosenItem.getmRemoveButton());
        productViewHolder.quantity.setText(chosenItem.getmItemQuantity());
        productViewHolder.addButton.setText(chosenItem.getmAddButton());
        productViewHolder.subtotalTitle.setText(chosenItem.getmSubtotalTitle());
        productViewHolder.subtotal.setText(chosenItem.getmInitialSubtotal());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final ProductAdapter mAdapter;
        public TextView title;
        public ImageView image;
        public TextView price;
        public TextView description;
        public TextView quantityTitle;
        public Button removeButton;
        public TextView quantity;
        public Button addButton;
        public TextView subtotalTitle;
        public TextView subtotal;

        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            this.mAdapter = adapter;

            title = itemView.findViewById(R.id.item_title);
            image = itemView.findViewById(R.id.image_title);
            price = itemView.findViewById(R.id.item_price);
            description = itemView.findViewById(R.id.item_desc);
            quantityTitle = itemView.findViewById(R.id.quantity_title);
            removeButton = itemView.findViewById(R.id.item_remove);
            quantity = itemView.findViewById(R.id.item_quantity);
            addButton = itemView.findViewById(R.id.item_add);
            subtotalTitle = itemView.findViewById(R.id.subtotal_title);
            subtotal = itemView.findViewById(R.id.initial_subtotal);

            itemView.findViewById(R.id.item_remove).setOnClickListener(this);
            itemView.findViewById(R.id.item_add).setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int currentQuantity;
            double currentSubtotal;
            double currentPrice;

            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();

            // Use that to access the affected item.
            ItemShop clickedItem = mItemList.get(mPosition);
            currentQuantity = Integer.parseInt(clickedItem.getmItemQuantity());
            currentSubtotal = Double.parseDouble(clickedItem.getmInitialSubtotal());
            currentPrice = Double.parseDouble(clickedItem.getmItemPrice());

            switch (view.getId()) {
                case R.id.item_remove:
                    if (currentQuantity > 0) {
                        currentQuantity--;
                        clickedItem.setmItemQuantity(Integer.toString(currentQuantity));
                        currentSubtotal -= currentPrice;
                        clickedItem.setmInitialSubtotal(String.format("%.2f", currentSubtotal));
                    }

                    Log.d(LOG_TAG, "Update the quantity:  " + clickedItem.getmItemTitle() + ", "
                    + clickedItem.getmItemPrice());
                    break;
                case R.id.item_add:
                    currentQuantity++;
                    clickedItem.setmItemQuantity(Integer.toString(currentQuantity));
                    currentSubtotal += currentPrice;
                    clickedItem.setmInitialSubtotal(String.format("%.2f", currentSubtotal));

                    Log.d(LOG_TAG, "Update the quantity:  " + clickedItem.getmItemTitle() + ", "
                            + clickedItem.getmItemPrice());
                    break;
            }

            mItemList.set(mPosition, clickedItem);

            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}