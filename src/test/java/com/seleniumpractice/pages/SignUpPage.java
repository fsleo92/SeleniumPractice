package com.seleniumpractice.pages;

import com.seleniumpractice.locators.SignUpPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                SignUpPageLocators.PAGE_HEADING)).isDisplayed();
    }

    public String getHeading() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                SignUpPageLocators.PAGE_HEADING)).getText().trim();
    }

    public boolean areRegistrationFieldsVisible() {
        return isVisible(SignUpPageLocators.FIRST_NAME)
                && isVisible(SignUpPageLocators.LAST_NAME)
                && isVisible(SignUpPageLocators.EMAIL)
                && isVisible(SignUpPageLocators.PASSWORD)
                && isVisible(SignUpPageLocators.CREATE_BUTTON);
    }

    public void enterRegistrationDetails(String firstName, String lastName,
                                         String email, String password) {
        enterText(SignUpPageLocators.FIRST_NAME, firstName);
        enterText(SignUpPageLocators.LAST_NAME, lastName);
        enterText(SignUpPageLocators.EMAIL, email);
        enterText(SignUpPageLocators.PASSWORD, password);
    }

    public String getEnteredValue(String fieldName) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                locatorFor(fieldName))).getAttribute("value");
    }

    public String getPasswordInputType() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                SignUpPageLocators.PASSWORD)).getAttribute("type");
    }

    private boolean isVisible(org.openqa.selenium.By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    private void enterText(org.openqa.selenium.By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }

    private org.openqa.selenium.By locatorFor(String fieldName) {
        if ("first name".equalsIgnoreCase(fieldName)) {
            return SignUpPageLocators.FIRST_NAME;
        }
        if ("last name".equalsIgnoreCase(fieldName)) {
            return SignUpPageLocators.LAST_NAME;
        }
        if ("email".equalsIgnoreCase(fieldName)) {
            return SignUpPageLocators.EMAIL;
        }
        if ("password".equalsIgnoreCase(fieldName)) {
            return SignUpPageLocators.PASSWORD;
        }
        throw new IllegalArgumentException("Unknown registration field: " + fieldName);
    }
}
