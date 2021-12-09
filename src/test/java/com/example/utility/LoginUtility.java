package com.example.utility;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.pages.HomePage;
import com.example.pages.modals.LogInModal;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginUtility implements OnPage{
    WebDriverWait wait;
    LogInModal loginModal = new LogInModal();
    HomePage homePage = new HomePage();

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
        //wait.until(ExpectedConditions.visibilityOf(loginModal.getLoginForm()));
        wait.withTimeout(Duration.ofSeconds(3));
        username = getUsername(username);
        password = getPassword(password);
        SelenideElement unField = loginModal.getUsernameField();
        SelenideElement pwField = loginModal.getPasswordField();
        if (username != null) unField.sendKeys(username);
        if (password != null) pwField.sendKeys(password);
        clickLogin();
    }

    private String getUsername(String type) {
        switch (type.toLowerCase()) {
            case "valid": return System.getenv("username");
            case "invalid": return System.getenv("other-username");
            case "empty": return "";
            default: throw new IllegalArgumentException("The username type '" + type + "' is unhandled");
        }
    }

    private String getPassword(String type) {
        switch (type.toLowerCase()) {
            case "valid": return System.getenv("password");
            case "invalid": return System.getenv("other-password");
            case "empty": return "";
            default: throw new IllegalArgumentException("The password type '" + type + "' is unhandled");
        }
    }

    public void clickLogin() {
        loginModal.getLoginBtn().click();
    }

    public void closeModal() {
        if (loginModal.modal.isDisplayed()) {
            loginModal.getCloseBtn().click();
        }
    }
}
