Feature: Sauce Demo customer registration
  As a shopper
  I want to view and enter details in the registration form
  So that I can check the account creation page before submitting

  @smoke
  Scenario: Home page opens
    Given the Sauce Demo home page is open
    Then the store logo is displayed

  @registration
  Scenario: Open the sign-up page from the home page
    Given the Sauce Demo home page is open
    When the shopper opens the sign-up page
    Then the create account page is displayed

  @registration
  Scenario: Registration form fields are available
    Given the Sauce Demo home page is open
    When the shopper opens the sign-up page
    Then all registration fields and the Create button are displayed

  @registration
  Scenario: Enter registration details without submitting
    Given the Sauce Demo home page is open
    When the shopper opens the sign-up page
    And the shopper enters first name "Alex", last name "Trainer", email "alex.trainer@example.com", and password "Training123!"
    Then the registration details are present and the password is masked
