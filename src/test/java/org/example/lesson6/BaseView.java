package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class BaseView {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
