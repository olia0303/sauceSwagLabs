package com.swag_labs.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends BasePage{

    private final String ADD_TO_CART_PRODUCT_BUTTON = FIELD_XPATH + "/ancestor::div[2]//button[text()='Add to cart']";
    private final String SELECT_OPTION_XPATH = "//select//option[contains(text(),'%s')]";
    private final String ITEM_NAME = "//div[contains(@class,'inventory_item_name')]";
    private final String ITEM_PRICE = "//div[contains(@class,'inventory_item_price')]";

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

    public HomePage selectValue(String option) {
        $(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
        return this;
    }

    public List<String> getProductByName() {
        ElementsCollection productElements = $$(By.xpath(String.format(ITEM_NAME)));
        List<String> actualProductNamesList = new ArrayList<>();
        for (SelenideElement productElement: productElements) {
            actualProductNamesList.add(productElement.getText());
        }
        return actualProductNamesList;
    }

    public List<String> getProductByPrice() {
        ElementsCollection productElements = $$(By.xpath(String.format(ITEM_PRICE)));
        List<String> actualProductPriceList = new ArrayList<>();
        for (SelenideElement productElement: productElements) {
            actualProductPriceList.add(productElement.getText());
        }
        return actualProductPriceList;
    }

    public void logOut() {
        $("#logout_sidebar_link").click();
    }
}