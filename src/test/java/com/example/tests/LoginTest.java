package com.example.tests;

import com.example.utility.LoginUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginTest {
    private LoginUtility utility = new LoginUtility();

    @Given("^user is logged out$")
    public void userIsLoggedOut() {
        utility.logout();
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        utility.login();
    }

    @Given("login credentials are filled with {string} and {string}")
    public void loginCredentialsAreFilledWithAnd(String username, String password) {
        utility.fillCredentials(username, password);
    }

    @When("I click login button")
    public void iClickLoginButton() {
        utility.clickLogin();
    }

    @Then("user should be logged in")
    public void userShouldBeLoggedIn() {
        Assertions.assertTrue(utility.isLoggedIn());
    }

    @And("is on url")
    public void isOnUrl() {
        utility.openHomePage();
    }
}
