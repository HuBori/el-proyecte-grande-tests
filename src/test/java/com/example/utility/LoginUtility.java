package com.example.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.pages.HomePage;
import com.example.pages.ListEmployeesPage;
import com.example.pages.modals.LogInModal;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class LoginUtility implements OnPage{
    WebDriverWait wait;
    LogInModal loginModal = new LogInModal();
    HomePage homePage = new HomePage();
    ListEmployeesPage listEmployeesPage = new ListEmployeesPage();


    public void login() {
        if (!isLoggedIn()) {
            homePage.getLogInBtn().click();
            wait.until(ExpectedConditions.visibilityOf(loginModal.getLoginForm()));
            fillCredentials("valid", "valid");
            clickLogin();
        }
    }

    public void openHomePage(){
        navigateToUrl(homePage.url);
    }

    public void logout() {
        if(isLoggedIn()) {
            homePage.getLogoutBtn().click();
        }
    }

    public boolean isLoggedIn() {
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        navigateToUrl(listEmployeesPage.url, wait);
        System.out.println(listEmployeesPage.url);
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
        return listEmployeesPage.url.equals(WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    public void fillCredentials(String username, String password) {
        loginModal.getUsernameField().sendKeys(getUsername(username));
        loginModal.getPasswordField().sendKeys(getPassword(password));
    }

    private String getUsername(String type) {
        switch (type.toLowerCase()) {
            case "valid": return System.getenv("username");
            case "invalid": return System.getenv("other-username");
            default: return "";
        }
    }

    private String getPassword(String type) {
        switch (type.toLowerCase()) {
            case "valid": return System.getenv("password");
            case "invalid": return System.getenv("other-password");
            default: return "";
        }
    }

    public void clickLogin() {
        loginModal.getLoginBtn().click();
    }
}
