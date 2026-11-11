package com.seleniumpractice.hooks;

import com.seleniumpractice.config.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class ScenarioHooks {
    public static final String BASE_URL = "https://sauce-demo.myshopify.com/";

    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.startDriver(System.getProperty("browser", "chrome"));
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
