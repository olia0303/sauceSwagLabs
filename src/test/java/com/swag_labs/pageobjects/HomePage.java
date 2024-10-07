package com.swag_labs.pageobjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage{

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

    public HomePage addToCartBackPack() {
        $("#add-to-cart-sauce-labs-backpack").click();
        return this;
    }

    public HomePage addToCartFleeceJacket() {
        $("#add-to-cart-sauce-labs-fleece-jacket").click();
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