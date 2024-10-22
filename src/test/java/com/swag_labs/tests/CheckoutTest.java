package com.swag_labs.tests;

import com.swag_labs.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(description = "Check empty last name and valid first name and valid postal code")
    public void emptyLastNameCheckout() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .addProductToCart("Sauce Labs Backpack")
                .openCartContainer();
        cartPage.isPageOpened()
                .checkout();
        checkoutPage.isPageOpened()
                .fillInfo(testData.FIRST_NAME, "", testData.ZIP_CODE)
                .continueAction();
        assertEquals(loginPage.getErrorMessage(), "Error: Last Name is required");
    }

    @Test(description = "Check empty first name and valid last name and valid postal code")
    public void emptyFirstNameCheckout() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .addProductToCart("Sauce Labs Backpack")
                .openCartContainer();
        cartPage.isPageOpened()
                .checkout();
        checkoutPage.isPageOpened()
                .fillInfo("", testData.LAST_NAME, testData.ZIP_CODE)
                .continueAction();
        assertEquals(loginPage.getErrorMessage(), "Error: First Name is required");
    }

    @Test(description = "Check valid first name and valid last name and empty postal code")
    public void emptyPostalCodeCheckout() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .addProductToCart("Sauce Labs Backpack")
                .openCartContainer();
        cartPage.isPageOpened()
                .checkout();
        checkoutPage.isPageOpened()
                .fillInfo(testData.FIRST_NAME, testData.LAST_NAME, "")
                .continueAction();
        assertEquals(loginPage.getErrorMessage(), "Error: Postal Code is required");
    }

    @Test(description = "Creation of product purchase and checkout")
    public void productShouldBeBought() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .addProductToCart("Sauce Labs Backpack")
                .openCartContainer();
        cartPage.isPageOpened()
                .checkout();
        checkoutPage.isPageOpened()
                .fillInfo(testData.FIRST_NAME, testData.LAST_NAME, testData.ZIP_CODE)
                .continueAction();
        checkoutPage.isCheckoutOverViewPageOpened()
                .finish();
        checkoutPage.checkoutComplete();
    }

    @Test(description = "Creation of product purchase and check item total price")
    public void productItemTotalPrice() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .addProductToCart("Sauce Labs Backpack")
                .openCartContainer();
        cartPage.isPageOpened()
                .checkout();
        checkoutPage.isPageOpened()
                .fillInfo(testData.FIRST_NAME, testData.LAST_NAME, testData.ZIP_CODE)
                .continueAction();
        checkoutPage.isCheckoutOverViewPageOpened();
        assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), checkoutPage.getProductItemTotalPrice(),
                "Item total price should be correct");
    }

    @Test(description = "Creation of products purchase and checkout")
    public void productsShouldBeBought() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .addProductToCart("Sauce Labs Onesie")
                .addProductToCart("Sauce Labs Bike Light")
                .addProductToCart("Sauce Labs Fleece Jacket")
                .addProductToCart("Test.allTheThings() T-Shirt (Red)")
                .openCartContainer();
        cartPage.isPageOpened();
        assertEquals(cartPage.getProductsInCart(), 6, "Incorrect number of items in cart container");
        cartPage.checkout();
        checkoutPage.isPageOpened()
                .fillInfo(testData.FIRST_NAME, testData.LAST_NAME, testData.ZIP_CODE)
                .continueAction();
        checkoutPage.isCheckoutOverViewPageOpened()
                .finish();
        checkoutPage.checkoutComplete();
    }
}