package com.example.utility;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public interface OnPage {
    default void navigateToUrl(String url){
        open(url);
    }
}
