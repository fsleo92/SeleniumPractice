package com.seleniumpractice.pages;

import com.seleniumpractice.locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                HomePageLocators.STORE_LOGO)).isDisplayed();
    }

    public SignUpPage openSignUpPage() {
        wait.until(ExpectedConditions.elementToBeClickable(
                HomePageLocators.SIGN_UP_LINK)).click();
        return new SignUpPage(driver);
    }
}
