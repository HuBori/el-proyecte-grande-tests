package com.example.steps;

import com.example.utility.ListAllEmployeeUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ListAllEmployeesSteps {
    ListAllEmployeeUtility utility = new ListAllEmployeeUtility();
    int numberOfEmployees;

    @Given("I have x of employees")
    public void iHaveNumberOfEmployees() {numberOfEmployees = utility.getEmployeeNumber();}

    @Then("I should see {string} as total number of employees")
    public void iShouldSeeAsTotalNumberOfEmployees(String envVariableName) {
        int employeeNumber = Integer.parseInt(System.getenv(envVariableName));
        Assertions.assertEquals(employeeNumber, numberOfEmployees);
    }

    @When("I search for {string} in the search bar")
    public void iSearchForNameInTheSearchBar(String employeeName) {
        utility.searchForName(employeeName);
    }


    @Then("I should see the search results {string} {string}")
    public void iShouldSeeTheSearchResults(String employeeName, String status) {
        switch (status) {
            case "true":
                Assertions.assertTrue(utility.isEmployeePresentInTable(employeeName));
                break;
            case "false":
                Assertions.assertFalse(utility.isEmployeePresentInTable(employeeName));
                break;
        }
    }

    @And("{string} is bigger than {string}")
    public void isBiggerThan(String numberOfEmployees, String employeePerPage) {
        Assertions.assertTrue(utility.compareNumbers(Integer.parseInt(System.getenv(numberOfEmployees)), Integer.parseInt(employeePerPage)));
    }

    @Then("next button should be active")
    public void nextButtonShouldBeActive() {
        Assertions.assertTrue(utility.isNextBtnActive());
    }

    @When("I press next button")
    public void iPressNextButton() {
        utility.clickNextBtn();
    }

    @Then("table content should change")
    public void tableContentShouldChange() {
        Assertions.assertTrue(utility.tableContentChanged());
    }

    @Then("prev button should be active")
    public void prevButtonShouldBeActive() {
        Assertions.assertTrue(utility.isPrevBtnActive());
    }

    @When("I press prev button")
    public void iPressPrevButton() {
        utility.clickPrevBtn();
    }

    @Given("employee {string} is present in the list")
    public void employeeIsPresentInTheList(String employeeName) {
        utility.setAndCheckEmployeeElement(employeeName);
    }

    @When("I click on {string}")
    public void iClickOn(String employeeName) {
        utility.clickOn(employeeName);
    }

    @Then("I should be redirected to {string} and displayed {string} is valid")
    public void iShouldBeRedirectedToDetails(String url, String name) {
        String expectedURL = url;
        Assertions.assertEquals(expectedURL, utility.getCurrentUrl());
        Assertions.assertTrue(utility.validateData(name));
    }

    @When("i click on all employees")
    public void iClickOnAllEmployees() {
        utility.navigateToAllEmployee();
    }

    @Then("user is promted to log in")
    public void userIsPromtedToLogIn() {
        utility.logIn();
    }
}
