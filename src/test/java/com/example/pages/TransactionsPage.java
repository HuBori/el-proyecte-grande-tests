package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TransactionsPage extends GeneralPage {
    public final String url = "http://localhost:3000/transactions";
    private final SelenideElement transactionsHeader = $x("//h4[@id='transactionsHeader']");
    private final SelenideElement filterFromField = $x("//input[@placeholder='From']");
    private final SelenideElement filterToField = $x("//input[@placeholder='To']");
    private final SelenideElement nextBtn = $x("//button[contains(text(),'Next')]");
    private final SelenideElement prevBtn = $x("//button[contains(text(),'Prev')]");
    private final SelenideElement transactionTable = $x("//table[@class='transaction-list table table-striped']");
    //TODO table without any lever, ask about it.

}
