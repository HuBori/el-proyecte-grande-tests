package com.example.utility;

import static com.codeborne.selenide.Selenide.open;

public interface OnPage {
    default void navigateToUrl(String url){
        open(url);
    }
}
