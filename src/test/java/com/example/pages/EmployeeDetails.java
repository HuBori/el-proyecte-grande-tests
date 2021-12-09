package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EmployeeDetails {
    SelenideElement employeeName = $x("//td[contains(text(), 'Name')]/following-sibling::td");

    public SelenideElement getEmployeeName() {
        return employeeName;
    }
}
