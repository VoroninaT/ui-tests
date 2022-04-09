package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SmartphonesPage {
    private SelenideElement smartphonesButton = $(By.xpath("//a[@target='_self'][contains(.,'Смартфоны')]"));

    private SelenideElement addToCartButton = $(By.xpath("//button[contains(.,'В корзину')][1]"));

    private SelenideElement CartButton = $(By.xpath("//a[@href='/cart' ]"));

    @Step("Клик на кнопку Смартфоны")
    public  void clickSmartphonesButton(){
        smartphonesButton.click();
    }

    @Step("Клик на кнопку В корзину")
    public  void clickAddToCartButton(){
        addToCartButton.click();
    }

    @Step("Клик на кнопку Корзина")
    public  void clickCartButton(){
        CartButton.click();
    }
}
