package com.example.utility;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public interface OnPage {
    default void navigateToUrl(String url){
        open(url);
    }

    default void navigateToUrl(String url, WebDriverWait wait){
        wait.withTimeout(Duration.ofSeconds(10));
        open(url);
    }
}
