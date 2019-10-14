package com.earljaepal.palisocnicershop.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ItemShop implements Parcelable {
    private String mItemTitle;
    private int mItemImage;
    private String mItemPrice;
    private String mItemDescription;

    private String mQuantityTitle;
    private String mRemoveButton;
    private String mItemQuantity;
    private String mAddButton;
    private String mSubtotalTitle;
    private String mInitialSubtotal;

    public ItemShop(String mItemTitle, int mItemImage, String mItemPrice, String mItemDescription,
                    String mQuantityTitle, String mRemoveButton, String mItemQuantity,
                    String mAddButton, String mSubtotalTitle, String mInitialSubtotal) {
        this.mItemTitle = mItemTitle;
        this.mItemImage = mItemImage;
        this.mItemPrice = mItemPrice;
        this.mItemDescription = mItemDescription;
        this.mQuantityTitle = mQuantityTitle;
        this.mRemoveButton = mRemoveButton;
        this.mItemQuantity = mItemQuantity;
        this.mAddButton = mAddButton;
        this.mSubtotalTitle = mSubtotalTitle;
        this.mInitialSubtotal = mInitialSubtotal;
    }


    public String getmItemTitle() {
        return mItemTitle;
    }

    public void setmItemTitle(String mItemTitle) {
        this.mItemTitle = mItemTitle;
    }

    public int getmItemImage() {
        return mItemImage;
    }

    public void setmItemImage(int mItemImage) {
        this.mItemImage = mItemImage;
    }

    public String getmItemPrice() {
        return mItemPrice;
    }

    public void setmItemPrice(String mItemPrice) {
        this.mItemPrice = mItemPrice;
    }

    public String getmItemDescription() {
        return mItemDescription;
    }

    public void setmItemDescription(String mItemDescription) {
        this.mItemDescription = mItemDescription;
    }

    public String getmQuantityTitle() {
        return mQuantityTitle;
    }

    public void setmQuantityTitle(String mQuantityTitle) {
        this.mQuantityTitle = mQuantityTitle;
    }

    public String getmRemoveButton() {
        return mRemoveButton;
    }

    public void setmRemoveButton(String mRemoveButton) {
        this.mRemoveButton = mRemoveButton;
    }

    public String getmItemQuantity() {
        return mItemQuantity;
    }

    public void setmItemQuantity(String mItemQuantity) {
        this.mItemQuantity = mItemQuantity;
    }

    public String getmAddButton() {
        return mAddButton;
    }

    public void setmAddButton(String mAddButton) {
        this.mAddButton = mAddButton;
    }

    public String getmSubtotalTitle() {
        return mSubtotalTitle;
    }

    public void setmSubtotalTitle(String mSubtotalTitle) {
        this.mSubtotalTitle = mSubtotalTitle;
    }

    public String getmInitialSubtotal() {
        return mInitialSubtotal;
    }

    public void setmInitialSubtotal(String mInitialSubtotal) {
        this.mInitialSubtotal = mInitialSubtotal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mItemTitle);
        parcel.writeInt(this.mItemImage);
        parcel.writeString(this.mItemPrice);
        parcel.writeString(this.mItemDescription);
        parcel.writeString(this.mQuantityTitle);
        parcel.writeString(this.mRemoveButton);
        parcel.writeString(this.mItemQuantity);
        parcel.writeString(this.mAddButton);
        parcel.writeString(this.mSubtotalTitle);
        parcel.writeString(this.mInitialSubtotal);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ItemShop createFromParcel(Parcel in) {
            return new ItemShop(in);
        }

        public ItemShop[] newArray(int size) {
            return new ItemShop[size];
        }
    };

    // Parcelling part
    public ItemShop(Parcel in){
        this.mItemTitle = in.readString();
        this.mItemImage = in.readInt();
        this.mItemPrice = in.readString();
        this.mItemDescription = in.readString();
        this.mQuantityTitle = in.readString();
        this.mRemoveButton = in.readString();
        this.mItemQuantity = in.readString();
        this.mAddButton = in.readString();
        this.mSubtotalTitle = in.readString();
        this.mInitialSubtotal = in.readString();
    }
}
