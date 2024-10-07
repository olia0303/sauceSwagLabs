package com.swag_labs.pageobjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage{

    private final String FIELD_XPATH = "//div[normalize-space(text())=\"%s\"]";

    @Override
    public CartPage isPageOpened() {
        $(By.xpath(" //span[contains(text(),'Your Cart')]")).shouldBe(Condition.visible);
        return this;
    }

    public void checkout() {
        $("#checkout").click();
    }

    public void clickRemoveFleeceJacket() {
        $("#remove-sauce-labs-fleece-jacket").click();
    }

    public boolean productExists(String fieldTitle) {
        return $(By.xpath(String.format(FIELD_XPATH, fieldTitle))).isDisplayed();
    }
}