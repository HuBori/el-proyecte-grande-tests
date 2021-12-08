package com.example.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.pages.HomePage;
import com.example.pages.ListEmployeesPage;
import com.example.pages.modals.LogInModal;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.open;

public class LoginUtility {
    WebDriverWait wait;
    LogInModal loginModal = new LogInModal();
    HomePage homePage = new HomePage();
    ListEmployeesPage listEmployeesPage = new ListEmployeesPage();

    public void login() {
        open(homePage.url);
        if (!isLoggedIn()) {
            homePage.getLogInBtn().click();
            wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
            // TODO: wait for loginForm?
            fillCredentials("valid", "valid");
            clickLogin();
        }
        // assertTrue(isLoggedIn());
    }

    public void logout() {
        homePage.getLogoutBtn().click();
    }

    private boolean isLoggedIn() {
        open(listEmployeesPage.url);
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
