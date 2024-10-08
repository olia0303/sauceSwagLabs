package com.swag_labs.tests;

import com.swag_labs.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SwagLabsTest extends BaseTest {
    @Test(description = "Sign In")
    public void createAccount() {
        loginPage.openPage()
                 .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .openMenuSwag()
                .logOut();
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
}