package com.earljaepal.palisocnicershop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.earljaepal.palisocnicershop.model.ItemShop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MenuActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE =
            "com.earljaepal.palisocshop.extra.MESSAGE";

    public static final String EXTRA_MESSAGE2 =
            "com.earljaepal.palisocshop.extra.MESSAGE2";

    private static final String CURRENT_ITEMS = "current items";

    private ArrayList<ItemShop> mItems = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    private int selectedOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder shippingAlert = new AlertDialog.Builder(MenuActivity.this);

                // Set the dialog title and message.
                shippingAlert.setTitle("View Cart");
                shippingAlert.setSingleChoiceItems(getResources().getStringArray(R.array.delivery_choice), -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                selectedOption = i;
                            }
                        });
                // Set the action buttons
                shippingAlert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so add the selected option cost to the total
                        Intent checkout = new Intent(MenuActivity.this, CheckoutActivity.class);
                        String [] options = getResources().getStringArray(R.array.delivery_choice);
                        String option = options[selectedOption];
                        checkout.putExtra(EXTRA_MESSAGE, option);

                        checkout.putParcelableArrayListExtra(EXTRA_MESSAGE2, mItems);
                        startActivity(checkout);
                        Log.d(LOG_TAG, "Proceed to checkout");
                    }
                });
                shippingAlert.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // or return them to the component that opened the dialog
                    }
                });

                shippingAlert.show();
            }
        });

        ItemShop item1 = new ItemShop(getResources().getString(R.string.item1_name),
                R.drawable.mach_bike,
                getResources().getString(R.string.item1_price),
                getResources().getString(R.string.item1_description),
                getResources().getString(R.string.quantity),
                getResources().getString(R.string.remove_button),
                getResources().getString(R.string.initial_quantity),
                getResources().getString(R.string.add_button),
                getResources().getString(R.string.subtotal_title),
                getResources().getString(R.string.initial_subtotal)
        );

        mItems.add(item1);

        ItemShop item2 = new ItemShop(getResources().getString(R.string.item2_name),
                R.drawable.acro_bike,
                getResources().getString(R.string.item2_price),
                getResources().getString(R.string.item2_description),
                getResources().getString(R.string.quantity),
                getResources().getString(R.string.remove_button),
                getResources().getString(R.string.initial_quantity),
                getResources().getString(R.string.add_button),
                getResources().getString(R.string.subtotal_title),
                getResources().getString(R.string.initial_subtotal)
        );

        mItems.add(item2);

        ItemShop item3 = new ItemShop(getResources().getString(R.string.item3_name),
                R.drawable.acro_bike,
                getResources().getString(R.string.item3_price),
                getResources().getString(R.string.item3_description),
                getResources().getString(R.string.quantity),
                getResources().getString(R.string.remove_button),
                getResources().getString(R.string.initial_quantity),
                getResources().getString(R.string.add_button),
                getResources().getString(R.string.subtotal_title),
                getResources().getString(R.string.initial_subtotal)
        );

        mItems.add(item3);

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ProductAdapter(this, mItems);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (savedInstanceState != null) {
            mItems = savedInstanceState.getParcelableArrayList(CURRENT_ITEMS);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("CURRENT_ITEMS", mItems);
    }


}
