package com.example.steps;

import com.codeborne.selenide.WebDriverRunner;
import com.example.utility.GeneralUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class GeneralSteps {
    private GeneralUtility utility = new GeneralUtility();

    @When("I click {string} button")
    public void iClickButton(String button) {
        utility.clickButton(button);
    }

    @Then("{string} page should be open")
    public void pageShouldBeOpen(String page) {
        Assertions.assertTrue(utility.isPageOpen(page));
    }

    @When("I refresh current page")
    public void iRefreshCurrentPage() {
        WebDriverRunner.getWebDriver().navigate().refresh();
    }
}
