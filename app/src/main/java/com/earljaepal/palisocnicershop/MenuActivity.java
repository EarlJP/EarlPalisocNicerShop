package com.earljaepal.palisocnicershop;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

    private static final String CURRENT_ITEMS = "current items";

    private ArrayList<ItemShop> mItems = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
