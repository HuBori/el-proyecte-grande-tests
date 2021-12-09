package com.example.utility;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.pages.EmployeeDetails;
import com.example.pages.HomePage;
import com.example.pages.ListEmployeesPage;
import com.example.pages.modals.LogInModal;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ListAllEmployeeUtility implements OnPage {
    WebDriverWait wait;
    ListEmployeesPage employeesPage = new ListEmployeesPage();
    HomePage homePage = new HomePage();
    EmployeeDetails employeeDetails = new EmployeeDetails();
    LogInModal modal = new LogInModal();
    String firstRow;
    String lastRow;


    public int getEmployeeNumber() {
        //WARNING works only with 99 or fewer employees
        int employeeNumber;
        String employeesNumberDiv = employeesPage.getNumberOfEmployeesDiv().text();

        String maxEmployeeNumber = employeesNumberDiv.substring(Math.max(employeesNumberDiv.length() - 2, 0));

        employeeNumber = Integer.parseInt(maxEmployeeNumber);
        return employeeNumber;
    }

    public boolean isNextBtnActive() {
        return employeesPage.getNextBtn().has(Condition.enabled);
    }

    public void navigateToAllEmployee(){
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        homePage.getEmployeesDropDownBtn().click();
        wait.until(ExpectedConditions.visibilityOf(homePage.getEmployeesListOption()));
        homePage.getEmployeesListOption().click();
    }

    public void logIn() {
        if(modal.modal.isDisplayed()) {
            modal.getUsernameField().sendKeys(System.getenv("username"));
            modal.getPasswordField().sendKeys(System.getenv("password"));
            modal.getLoginForm().submit();
            homePage.getEmployeesListOption().click();
        }
    }

    public void setAndCheckEmployeeElement(String employeeName) {
        employeesPage.setEmployeeNameAndLink(employeeName);
    }

    public void clickOn(String employeeName) {
        setAndCheckEmployeeElement(employeeName);
        employeesPage.getEmployeeLink().click();
    }

    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public boolean validateData(String name) {
        return name.equals(employeeDetails.getEmployeeName().text());
    }

    public void searchForName(String employeeName) {
        employeesPage.getFilterByNameField().sendKeys(employeeName);
        wait.withTimeout(Duration.ofSeconds(1));
    }

    public boolean isEmployeePresentInTable(String employeeName) {
        setAndCheckEmployeeElement(employeeName);
        return employeesPage.getEmployeeLink().isDisplayed();
    }

    public boolean compareNumbers(int numberOfEmployees, int employeePerPage) {
        return numberOfEmployees > employeePerPage;
    }

    public void clickNextBtn() {
        employeesPage.setFirstAndLastEmployeeLinkDisplayed();
        firstRow = employeesPage.getFirstEmployeeLinkDisplayed().text();
        lastRow = employeesPage.getLastEmployeeLinkDisplayed().text();
        employeesPage.getNextBtn().click();
    }

    public boolean tableContentChanged() {
        //TODO maybe compare all of the table??????
        employeesPage.setFirstAndLastEmployeeLinkDisplayed();
        return !(firstRow.equals(employeesPage.getFirstEmployeeLinkDisplayed().text())
                && lastRow.equals(employeesPage.getLastEmployeeLinkDisplayed().text()));
    }

    public boolean isPrevBtnActive() {
        return employeesPage.getPrevBtn().has(Condition.enabled);
    }

    public void clickPrevBtn() {
        employeesPage.setFirstAndLastEmployeeLinkDisplayed();
        firstRow = employeesPage.getFirstEmployeeLinkDisplayed().text();
        lastRow = employeesPage.getLastEmployeeLinkDisplayed().text();
        employeesPage.getPrevBtn().click();
    }
}
