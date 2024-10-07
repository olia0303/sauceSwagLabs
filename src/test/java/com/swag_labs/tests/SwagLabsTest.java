package com.swag_labs.tests;

import com.swag_labs.BaseTest;
import com.swag_labs.model.ProductItem;
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
                .addToCartBackPack()
                .openCartContainer();
        cartPage.isPageOpened()
                     .checkout();
        checkoutPage.isPageOpened()
                     .fillInfo(testData.FIRST_NAME, testData.LAST_NAME, testData.ZIP_CODE)
                     .clickContinue();
        checkoutPage.isCheckoutOverViewPageOpened()
                    .clickFinish();
        checkoutPage.checkoutComplete();
    }

    @Test(description = "Creation of product purchase and remove")
    public void productShouldBeRemoved() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened()
                .addToCartFleeceJacket()
                .openCartContainer();
        assertTrue(cartPage.productExists(ProductItem.SAUCE_LABS_FLEECE.getItem()));
        cartPage.isPageOpened()
                .clickRemoveFleeceJacket();
        cartPage.checkout();
        assertFalse(cartPage.productExists(ProductItem.SAUCE_LABS_FLEECE.getItem()));
    }
}