package com.swag_labs.pageobjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.swag_labs.other.Urls.LOGIN_PAGE;

public class LoginPage extends BasePage{

    private final By ERROR_MESSAGE = By.xpath("//div[@class='error-message-container error']//h3");
    public LoginPage openPage(){
        open(LOGIN_PAGE);
        return this;
    }

    public LoginPage logIn(String username, String password){
        isPageOpened();
        $("#user-name").sendKeys(username);
        $("#password").sendKeys(password);
        $("#login-button").click();
        return this;
    }

    public String getErrorMessage() {
        String fieldErrorMessage = $(ERROR_MESSAGE).getText();
        return fieldErrorMessage;
    }

    @Override
    public LoginPage isPageOpened(){
        $("#login_button_container").shouldBe(Condition.visible);
        return this;
    }
}