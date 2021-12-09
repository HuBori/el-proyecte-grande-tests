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
    private final SelenideElement numberOfEmployeesDiv = $x("//div[@class='showText']");
    private SelenideElement employeeLink;
    private SelenideElement firstEmployeeLinkDisplayed;
    private SelenideElement lastEmployeeLinkDisplayed;


    public void setEmployeeNameAndLink(String employeeName) {
        // same name employees???? maybe use the database ids???
        this.employeeName = employeeName;
        this.employeeLink = $x("//a[contains(text(),'"+ employeeName+"')]");
    }

    public SelenideElement getNumberOfEmployeesDiv() {
        return numberOfEmployeesDiv;
    }

    public SelenideElement getNextBtn() {
        return nextBtn;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public SelenideElement getPrevBtn() {
        return prevBtn;
    }

    public SelenideElement getFilterByNameField() {
        return filterByNameField;
    }

    public SelenideElement getEmployeesTable() {
        return employeesTable;
    }

    public SelenideElement getEmployeeLink() {
        return employeeLink;
    }

    public void setFirstAndLastEmployeeLinkDisplayed(){
        firstEmployeeLinkDisplayed = $x("//tbody/tr[1]/td/following-sibling::td");
        lastEmployeeLinkDisplayed = $x("(//tr[last()]/td/following-sibling::td)");
    }

    public SelenideElement getFirstEmployeeLinkDisplayed() {
        return firstEmployeeLinkDisplayed;
    }

    public SelenideElement getLastEmployeeLinkDisplayed() {
        return lastEmployeeLinkDisplayed;
    }
}
