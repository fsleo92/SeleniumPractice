package com.seleniumpractice.locators;

import org.openqa.selenium.By;

public final class HomePageLocators {
    public static final By STORE_LOGO = By.cssSelector("#logo img[alt='Sauce Demo']");
    public static final By SIGN_UP_LINK = By.xpath("//a[@href='/account/register' and normalize-space()='Sign up']");

    private HomePageLocators() {
    }
}
