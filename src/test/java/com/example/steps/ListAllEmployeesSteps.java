package com.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListAllEmployeesSteps {
    @Given("I am on list all employees page")
    public void iAmOnListAllEmployeesPage() {
    }

    @And("I have {int} of employees")
    public void iHaveOfEmployees(int numberOfEmployees) {

    }

    @Then("I should see {int} as total number of employees")
    public void iShouldSeeAsTotalNumberOfEmployees(int numberOfEmployees) {

    }

    @When("I search for {string} in the search bar")
    public void iSearchForInTheSearchBar(String employeeName) {

    }


    @Then("I should see the search results {string} {string}")
    public void iShouldSeeTheSearchResults(String employeeName, String status) {
    }

    @And("{int} is bigger than {string}")
    public void isBiggerThan(int numberOfEmployees, String employeePerPage) {
        
    }

    @Then("next button should be active")
    public void nextButtonShouldBeActive() {
        
    }

    @When("I press next button")
    public void iPressNextButton() {
        
    }

    @Then("table content should change")
    public void tableContentShouldChange() {

    }

    @Then("prev button should be active")
    public void prevButtonShouldBeActive() {

    }

    @When("I press prev button")
    public void iPressPrevButton() {

    }
}
