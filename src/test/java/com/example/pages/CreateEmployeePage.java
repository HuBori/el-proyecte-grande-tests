package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateEmployeePage extends GeneralPage {
    public final String url = "http://localhost:3000/create-employee";
    private final SelenideElement newEmployeeForm = $x("//div[@class='employeeForm']");
    private final SelenideElement employeeName = $x("//input[@id='name']");
    private final SelenideElement employeePhone = $x("//input[@id='phoneNumber']");
    private final SelenideElement employeeEmail = $x("//input[@id='email']");
    private final SelenideElement employeeCountryDropdownTrigger = $x("//input[@id='country']");
    //TODO employeeCountryDropdownTrigger drop down options
    private final SelenideElement employeeCity = $x("//input[@id='city']");
    private final SelenideElement employeePostalCode = $x("//input[@id='postalCode']");
    private final SelenideElement employeeStreet = $x("//input[@id='street']");
    private final SelenideElement employeeHouseNumber = $x("//input[@id='houseNumber']");
    private final SelenideElement employeeSalary = $x("//input[@id='salary']");
    private final SelenideElement employeeStatusDropdownTrigger = $x("//input[@id='status']");
    //TODO employeeStatusDropdownTrigger drop down options
    private final SelenideElement employeePrivilegesDropdownTrigger = $x("//input[@id='privilege']");
    //TODO employeePrivilegesDropdownTrigger drop down options
    private final SelenideElement submitBtn = $x("//button[contains(text(),'Submit')]");

    public CreateEmployeePage() {
        super(userDisplayedName);
    }
}
