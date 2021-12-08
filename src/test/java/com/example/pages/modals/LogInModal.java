package com.example.pages.modals;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LogInModal {
    public final SelenideElement modal = $x("//div[@class='modal-title h4' and text()='Login']/../../..");
    private final SelenideElement loginForm = $x("//form"); // maybe an id???
    private final SelenideElement usernameField = $x("//input[@id='formBasicEmail']");
    private final SelenideElement passwordField = $x("//input[@id='formBasicPassword']");
    private final SelenideElement closeBtn = $x("//button[contains(text(),'Close')]");
    private final SelenideElement loginBtn = $x("//button[contains(text(),'Login')]");

    public SelenideElement getModal() {
        return modal;
    }

    public SelenideElement getLoginForm() {
        return loginForm;
    }

    public SelenideElement getUsernameField() {
        return usernameField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getCloseBtn() {
        return closeBtn;
    }

    public SelenideElement getLoginBtn() {
        return loginBtn;
    }
}
