package com.swag_labs;

import com.codeborne.selenide.Configuration;
import com.swag_labs.other.TestData;
import com.swag_labs.pageobjects.CheckoutPage;
import com.swag_labs.pageobjects.HomePage;
import com.swag_labs.pageobjects.LoginPage;
import com.swag_labs.tests.TestListener;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    public LoginPage loginPage;
    public TestData testData;
    public HomePage homePage;

    public CheckoutPage checkoutPage;

    @BeforeMethod(description = "Opening browser")
    public void startBrowser() {
        loginPage = new LoginPage();
        testData = new TestData();
        homePage = new HomePage();
        checkoutPage = new CheckoutPage();
        useChromeWithOptions();
    }

    public void useChromeWithOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities = options;
    }

    @AfterMethod(description = "Closing browser", alwaysRun = true)
    public void stopBrowser() {
    }
}