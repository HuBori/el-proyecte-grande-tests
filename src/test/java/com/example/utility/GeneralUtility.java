package com.example.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.pages.CreateEmployeePage;
import com.example.pages.HomePage;
import com.example.pages.ListEmployeesPage;
import com.example.pages.TransactionsPage;
import com.example.pages.modals.LogInModal;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralUtility {
    private HomePage homePage = new HomePage();
    private LogInModal loginModal = new LogInModal();
    private ListEmployeesPage listEmployeesPage = new ListEmployeesPage();
    private CreateEmployeePage createEmployeePage = new CreateEmployeePage();
    private TransactionsPage transactionsPage = new TransactionsPage();

    public void clickButton(String button) {
        switch (button.toLowerCase()) {
            case "login":
                homePage.getLogInBtn().click();
                break;
            case "employee list":
                homePage.getEmployeesDropDownBtn().click();
                homePage.getEmployeesListOption().click();
                break;
            case "create employee":
                homePage.getEmployeesDropDownBtn().click();
                homePage.getEmployeesCreateOption().click();
                break;
            case "transaction":
                homePage.getTransactionsDropDownBtn().click();
                homePage.getTransactionsOption().click();
                break;
            default:
                homePage.getHomeBtn().click();
                break;
        }
    }

    public boolean isPageOpen(String page) {
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        wait.withTimeout(Duration.ofSeconds(3));
        String expectedUrl;
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        if (page.equalsIgnoreCase("login")) return loginModal.modal.isDisplayed();
        switch (page.toLowerCase()) {
            case "employee list":
                expectedUrl = listEmployeesPage.url;
                break;
            case "create employee":
                expectedUrl = createEmployeePage.url;
                break;
            case "transaction":
                expectedUrl = transactionsPage.url;
                break;
            default:
                expectedUrl = homePage.url;
                break;
        }
        return expectedUrl.equals(currentUrl);
    }
}
