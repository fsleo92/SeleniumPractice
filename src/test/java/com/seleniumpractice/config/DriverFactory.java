package com.seleniumpractice.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();

    private DriverFactory() {
    }

    public static WebDriver startDriver(String browserName) {
        if (DRIVER.get() != null) {
            throw new IllegalStateException("A WebDriver is already running on this thread.");
        }

        String browser = browserName == null || browserName.trim().isEmpty()
                ? "chrome"
                : browserName.trim().toLowerCase();
        WebDriver driver;

        if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException(
                    "Unsupported browser '" + browserName + "'. Choose chrome or firefox.");
        }

        DRIVER.set(driver);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been started for this thread.");
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DRIVER.remove();
        }
    }
}
