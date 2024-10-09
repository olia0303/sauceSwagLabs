package com.swag_labs.tests;

import com.swag_labs.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SwagLabsTest extends BaseTest {
    @Test(description = "Check login with valid username and valid password.")
    public void createAccountSuccessful() {
        loginPage.openPage()
                 .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .openMenuSwag()
                .logOut();
    }

    @Test(description = "Check login with empty username and valid password.")
    public void emptyUsernameLogin() {
        loginPage.openPage()
                .logIn("", testData.PASS);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(description = "Check login with valid username and empty password.")
    public void emptyPasswordLogin() {
        loginPage.openPage()
                .logIn(testData.USER, "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test(description = "Check login with invalid username and invalid password.")
    public void invalidCredentialsLogin() {
        loginPage.openPage()
                .logIn(testData.FIRST_NAME, "1234");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
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