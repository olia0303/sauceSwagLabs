package com.swag_labs.tests;

import com.swag_labs.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CartContainerTest extends BaseTest {

    @Test(description = "Creation of product purchase and remove")
    public void productShouldBeRemoved() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .addProductToCart("Sauce Labs Fleece Jacket")
                .openCartContainer();
        assertTrue(cartPage.isProductExist("Sauce Labs Fleece Jacket"));
        cartPage.isPageOpened()
                .removeProduct("Sauce Labs Fleece Jacket");
        cartPage.checkout();
        assertFalse(cartPage.isProductExist("Sauce Labs Fleece Jacket"));
    }

    @Test(description = "Creation of product purchase and continue shopping")
    public void continueShopping() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .addProductToCart("Sauce Labs Fleece Jacket")
                .openCartContainer();
        assertTrue(cartPage.isProductExist("Sauce Labs Fleece Jacket"));
        cartPage.isPageOpened()
                .continueShopping();
        homePage.isPageOpened();
    }
}