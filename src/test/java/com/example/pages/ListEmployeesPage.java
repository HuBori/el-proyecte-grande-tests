package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ListEmployeesPage extends GeneralPage {
    public final String url = "http://localhost:3000/employees";
    private String employeeName = "";
    private final SelenideElement nextBtn = $x("//button[contains(text(),'Next')]");
    private final SelenideElement prevBtn = $x("//button[contains(text(),'Prev')]");
    private final SelenideElement filterByNameField = $x("//input[@placeholder='Filter by name']");
    private final SelenideElement employeesTable = $x("//table"); // maybe use an id?
    private SelenideElement employeeLink;

    public void setEmployeeNameAndLink(String employeeName) {
        // same name employees???? maybe use the database ids???
        this.employeeName = employeeName;
        this.employeeLink = $x("//a[contains(text(),'"+ employeeName+"')]");
    }
}
