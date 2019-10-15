package com.earljaepal.palisocnicershop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.earljaepal.palisocnicershop.model.ItemShop;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MenuActivity.class.getSimpleName();

    private ArrayList<ItemShop> mItems;
    private static final double TPS = 0.05;
    private static final double TVQ = 0.09975;

    /**
     * Creates the Checkout Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Get the total from the previous menu activity
        Intent intent = getIntent();
        String deliveryOption = (intent.getStringExtra(MenuActivity.EXTRA_MESSAGE));
        mItems = (intent.getParcelableArrayListExtra(MenuActivity.EXTRA_MESSAGE2));

        // Set the total before taxes with this intent
        TextView setTotal = findViewById(R.id.pretotal);
        TextView setDelivery = findViewById(R.id.delivery_option);

        setDelivery.setText(deliveryOption);
        Log.d(LOG_TAG, "Check the intent:  " + deliveryOption);

        double subtotal = calculateSubTotal();
        setTotal.setText("$" + subtotal);

        String stringTotal = calculatePreTotal(deliveryOption, subtotal);
        calculateTotal(stringTotal);
    }

    /**
     * Calculate the all the subtotals of the items ordered
     * @return
     */
    public double calculateSubTotal() {
        double subtotal = 0;

        // Loop through the list of items and add the subtotals up
        for (int i = 0; i < mItems.size(); i++)
            subtotal += Double.parseDouble(mItems.get(i).getmInitialSubtotal());

        return subtotal;
    }

    /**
     * Calculate the total with the chosen delivery option
     * @param option
     * @param total
     * @return
     */
    public String calculatePreTotal(String option, double total) {
        final double expressDelivery = 50;
        final double regularDelivery = 10;

        switch (option) {
            case "Express ($50)":
                total += expressDelivery;
                break;
            case "Regular ($10)":
                total += regularDelivery;
                break;
            case "No hurry (FREE)":
                total += 0;
        }
        Log.d(LOG_TAG, "Check the total:  " + total);
        return Double.toString(total);
    }

    /**
     * Method to calculate the final total
     * @param stringTotal
     */
    public void calculateTotal(String stringTotal) {
        double beforeTax;
        double afterTax;

        // Parse the string of the pre-total brought from the previous activity as an intent
        beforeTax = Double.parseDouble(stringTotal);
        // Calculate the final total
        afterTax = beforeTax + calculateTPS(beforeTax) + calculateTVQ(beforeTax);
        Log.d(LOG_TAG, "Check the calculation:  " + afterTax);

        // Set the final total
        TextView finalTotalText = findViewById(R.id.total);
        finalTotalText.setText(String.format("$%.2f", afterTax));
    }

    /**
     * Method to calculate the TPS to be added for the final total
     * @param beforeTotal
     * @return
     */
    public double calculateTPS(double beforeTotal) {
        double tax = beforeTotal * TPS;
        Log.d(LOG_TAG, "Check the calculation:  " + tax);
        TextView setTPS = findViewById(R.id.tps);
        setTPS.setText(String.format("%.2f", tax));
        return tax;
    }

    /**
     * Method to calculate the TVQ to be added for the final total
     * @param beforeTotal
     * @return
     */
    private double calculateTVQ(double beforeTotal) {
        double tax = beforeTotal * TVQ;
        Log.d(LOG_TAG, "Check the calculation:  " + tax);
        TextView setTPS = findViewById(R.id.tvq);
        setTPS.setText(String.format("%.2f", tax));
        return tax;
    }
}
