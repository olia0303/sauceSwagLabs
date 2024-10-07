package com.swag_labs.model;

public enum ProductItem {
    SAUCE_LABS_BACKPACK("Sauce Labs Backpack"),
    SAUCE_LABS_BOLT("Sauce Labs Bolt T-Shirt"),
    SAUCE_LABS_BIKE("Sauce Labs Bike Light"),
    SAUCE_LABS_FLEECE("Sauce Labs Fleece Jacket"),
    SAUCE_LABS_ONESIE("Sauce Labs Onesie"),
    TEST_ALL_THINGS("Test.allTheThings() T-Shirt (Red)");

    private String item;

    ProductItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}