package com.example.utility;

import com.example.pages.ListEmployeesPage;

public class ListAllEmployeeUtility implements OnPage {
    ListEmployeesPage employeesPage = new ListEmployeesPage();

    public void openPage() {
        navigateToUrl(employeesPage.url);
    }

}
