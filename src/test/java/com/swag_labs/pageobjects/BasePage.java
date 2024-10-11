package com.swag_labs.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    abstract protected BasePage isPageOpened();
    public final String FIELD_XPATH = "//div[normalize-space(text())=\"%s\"]";
    private final By ERROR_MESSAGE = By.xpath("//div[@class='error-message-container error']//h3");

    public String getErrorMessage() {
        String fieldErrorMessage = $(ERROR_MESSAGE).getText();
        return fieldErrorMessage;
    }
}