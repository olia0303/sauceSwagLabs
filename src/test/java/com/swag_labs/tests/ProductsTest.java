package com.swag_labs.tests;

import com.swag_labs.BaseTest;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(description = "Check the products in list sorted by name")
    public void sortedProductsByName() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened();
        homePage.selectValue("Name (A to Z)");
        List<String> productSortedByNameList = homePage.getProductsName();
        String firsProductList = productSortedByNameList.get(0);
        String lastProductList = productSortedByNameList.get(5);
        assertEquals(firsProductList, "Sauce Labs Backpack");
        assertEquals(lastProductList, "Test.allTheThings() T-Shirt (Red)");
    }

    @Test(description = "Check the products in list sorted by price")
    public void sortedProductsByPrice() {
        loginPage.openPage()
                .logIn(testData.USER, testData.PASS);
        homePage.isPageOpened();
        homePage.selectValue("Price (low to high)");
        List<String> productSortedByPiceList = homePage.getProductsPrice();
        String firsProductList = productSortedByPiceList.get(0);
        String lastProductList = productSortedByPiceList.get(5);
        assertEquals(firsProductList, "$7.99");
        assertEquals(lastProductList, "$49.99");
    }
}