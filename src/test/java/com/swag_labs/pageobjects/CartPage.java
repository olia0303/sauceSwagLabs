package com.swag_labs.pageobjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage{

    private final String REMOVE_PRODUCT_BUTTON = FIELD_XPATH + "/ancestor::div[2]//button[text()='Remove']";

    @Override
    public CartPage isPageOpened() {
        $(By.xpath(" //span[contains(text(),'Your Cart')]")).shouldBe(Condition.visible);
        return this;
    }

    public void checkout() {
        $("#checkout").click();
    }

    public void removeProduct(String productName) {
        $(By.xpath(String.format(REMOVE_PRODUCT_BUTTON, productName))).click();
    }

    public boolean isProductExist(String productName) {
        return $(By.xpath(String.format(FIELD_XPATH, productName))).isDisplayed();
    }
}