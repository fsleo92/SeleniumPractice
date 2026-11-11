package com.seleniumpractice.locators;

import org.openqa.selenium.By;

public final class SignUpPageLocators {
    public static final By PAGE_HEADING = By.cssSelector("#create-account h1.accounts-title");
    public static final By FIRST_NAME = By.cssSelector("form#create_customer input#first_name");
    public static final By LAST_NAME = By.cssSelector("form#create_customer input#last_name");
    public static final By EMAIL = By.cssSelector("form#create_customer input#email");
    public static final By PASSWORD = By.cssSelector("form#create_customer input#password");
    public static final By CREATE_BUTTON = By.cssSelector("form#create_customer input[type='submit'][value='Create']");

    private SignUpPageLocators() {
    }
}
