package com.swag_labs.pageobjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends BasePage {

    private final String ITEM_TOTAL = "//div[@class='summary_subtotal_label']";

    @Override
    public CheckoutPage isPageOpened() {
        $(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).shouldBe(Condition.visible);
        return this;
    }

    public CheckoutPage fillInfo(String username, String lastName, String zipCode) {
        $("#first-name").sendKeys(username);
        $("#last-name").sendKeys(lastName);
        $("#postal-code").sendKeys(zipCode);
        return this;
    }

    public void continueAction() {
        $("#continue").click();
    }

    public CheckoutPage isCheckoutOverViewPageOpened() {
        $(By.xpath("//span[contains(text(),'Checkout: Overview')]")).shouldBe(Condition.visible);
        return this;
    }

    public void finish() {
        $("#finish").click();
    }

    public String getProductItemTotalPrice() {
        return $(By.xpath(String.format(ITEM_TOTAL))).getText().split(" ")[2];
    }

    public CheckoutPage checkoutComplete() {
        $(By.xpath("//h2[contains(text(),'Thank you for your order!')]")).shouldBe(Condition.visible);
        return this;
    }
}
