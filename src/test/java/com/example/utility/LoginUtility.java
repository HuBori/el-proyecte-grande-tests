package com.example.utility;

import com.codeborne.selenide.WebDriverRunner;
import com.example.pages.HomePage;
import com.example.pages.ListEmployeesPage;
import com.example.pages.modals.LogInModal;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUtility implements OnPage{
    WebDriverWait wait;
    LogInModal loginModal = new LogInModal();
    HomePage homePage = new HomePage();
    ListEmployeesPage listEmployeesPage = new ListEmployeesPage();


    public void login() {
        if (!isLoggedIn()) {
            fillCredentials("valid", "valid");
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
        openHomePage();
        wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        if (loginModal.modal.isDisplayed()){
            wait.until(ExpectedConditions.invisibilityOf(loginModal.modal));
        }
        return !homePage.getLogInBtn().isDisplayed();
    }

    public void fillCredentials(String username, String password) {
        homePage.getLogInBtn().click();
        wait.until(ExpectedConditions.visibilityOf(loginModal.getLoginForm()));
        loginModal.getUsernameField().sendKeys(getUsername(username));
        loginModal.getPasswordField().sendKeys(getPassword(password));
        clickLogin();
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

    public void closeModal() {
        loginModal.getCloseBtn().click();
    }
}
