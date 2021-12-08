package com.example.utility;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.example.pages.ListEmployeesPage;

public class ListAllEmployeeUtility implements OnPage {
    ListEmployeesPage employeesPage = new ListEmployeesPage();

    public void openPage() {
        navigateToUrl(employeesPage.url);
    }

    public int getEmployeeNumber() {
        //WARNING works only with 99 or fewer employees
        int employeeNumber = 0;
        String employeesNumberDiv = employeesPage.getNumberOfEmployeesDiv().text();
        String maxEmployeeNumber = employeesNumberDiv.substring(Math.max(employeesNumberDiv.length() - 2, 0));
        employeeNumber = Integer.parseInt(maxEmployeeNumber);
        return employeeNumber;
    }

    public boolean isNextBtnActive() {
        return employeesPage.getNextBtn().has(Condition.enabled);
    }
}
