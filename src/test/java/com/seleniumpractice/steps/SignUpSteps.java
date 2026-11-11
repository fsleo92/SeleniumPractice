package com.seleniumpractice.steps;

import com.seleniumpractice.config.DriverFactory;
import com.seleniumpractice.pages.HomePage;
import com.seleniumpractice.pages.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignUpSteps {
    private HomePage homePage;
    private SignUpPage signUpPage;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Given("the Sauce Demo home page is open")
    public void theSauceDemoHomePageIsOpen() {
        homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue("The Sauce Demo home page did not load.", homePage.isLoaded());
    }

    @Then("the store logo is displayed")
    public void theStoreLogoIsDisplayed() {
        Assert.assertTrue("The Sauce Demo logo is not visible.", homePage.isLoaded());
    }

    @When("the shopper opens the sign-up page")
    public void theShopperOpensTheSignUpPage() {
        signUpPage = homePage.openSignUpPage();
    }

    @Then("the create account page is displayed")
    public void theCreateAccountPageIsDisplayed() {
        Assert.assertTrue("The Create Account heading is not visible.", signUpPage.isLoaded());
        Assert.assertEquals("Create Account", signUpPage.getHeading());
        Assert.assertTrue("The browser is not on the registration page.",
                DriverFactory.getDriver().getCurrentUrl().contains("/account/register"));
    }

    @Then("all registration fields and the Create button are displayed")
    public void allRegistrationFieldsAndTheCreateButtonAreDisplayed() {
        Assert.assertTrue("One or more registration fields are missing or hidden.",
                signUpPage.areRegistrationFieldsVisible());
    }

    @When("the shopper enters first name {string}, last name {string}, email {string}, and password {string}")
    public void theShopperEntersRegistrationDetails(String firstName, String lastName,
                                                     String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        signUpPage.enterRegistrationDetails(firstName, lastName, email, password);
    }

    @Then("the registration details are present and the password is masked")
    public void theRegistrationDetailsArePresentAndThePasswordIsMasked() {
        Assert.assertEquals(firstName, signUpPage.getEnteredValue("first name"));
        Assert.assertEquals(lastName, signUpPage.getEnteredValue("last name"));
        Assert.assertEquals(email, signUpPage.getEnteredValue("email"));
        Assert.assertEquals(password, signUpPage.getEnteredValue("password"));
        Assert.assertEquals("password", signUpPage.getPasswordInputType());
    }
}
