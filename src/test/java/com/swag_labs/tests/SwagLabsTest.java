package com.swag_labs.tests;

import com.swag_labs.BaseTest;
import org.testng.annotations.Test;

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
                .addToCartBackPack()
                .openCartContainer()
                .checkYouCart()
                .checkout();
        checkoutPage.isPageOpened()
                     .fillInfo(testData.FIRST_NAME, testData.LAST_NAME, testData.ZIP_CODE)
                     .clickContinue();
        checkoutPage.isCheckoutOverViewPageOpened()
                    .clickFinish();
        checkoutPage.checkoutComplete();
    }
}