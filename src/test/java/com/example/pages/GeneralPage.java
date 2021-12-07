package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public abstract class GeneralPage {
    public final String url = "http://localhost:3000/";
    private final SelenideElement logInBtn = $x(
            "//nav/div[@class='container']/span/button[@style='background-color: transparent; border: none;']");
    private final SelenideElement homeBtn = $x("//a[@href='/home']");
    private final SelenideElement employeesDropDownBtn = $x("//button[contains(text(),'Employees')]");
    private final SelenideElement employeesListOption = $x("//a[@href='/employees']");
    private final SelenideElement employeesCreateOption = $x("//a[@href='/create-employee']");
    private final SelenideElement transactionsDropDownBtn = $x("//button[contains(text(),'Transactions')]");
    private final SelenideElement transactionsOption = $x("//a[@href='/transactions']");
}
