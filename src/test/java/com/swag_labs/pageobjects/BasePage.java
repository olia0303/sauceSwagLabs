package com.swag_labs.pageobjects;

public abstract class BasePage {
    abstract protected BasePage isPageOpened();
    public final String FIELD_XPATH = "//div[normalize-space(text())=\"%s\"]";
}