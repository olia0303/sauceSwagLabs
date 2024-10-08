package com.swag_labs.pageobjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage{

    private final String ADD_TO_CART_PRODUCT_BUTTON = FIELD_XPATH + "/ancestor::div[2]//button[text()='Add to cart']";

    @Override
    public HomePage isPageOpened() {
        $(By.xpath("//span[contains(text(),'Products')]")).shouldBe(Condition.visible);
        return this;
    }

    public HomePage openMenuSwag() {
        $("#react-burger-menu-btn").click();
        $(".bm-menu").shouldBe(Condition.visible);
        return this;
    }

    public HomePage addProductToCart(String productName) {
        $(By.xpath(String.format(ADD_TO_CART_PRODUCT_BUTTON, productName))).click();
        return this;
    }

    public HomePage openCartContainer() {
        $("#shopping_cart_container").click();
        return this;
    }

    public void logOut() {
        $("#logout_sidebar_link").click();
    }
}