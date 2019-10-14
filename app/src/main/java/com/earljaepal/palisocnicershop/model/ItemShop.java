package com.earljaepal.palisocnicershop.model;

public class ItemShop {
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
}
