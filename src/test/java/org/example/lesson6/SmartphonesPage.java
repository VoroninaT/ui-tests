package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartphonesPage extends BaseView {

    public SmartphonesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@target='_self'][contains(.,'Смартфоны')]")
    public WebElement smartphonesButton;

    @FindBy(xpath = "//button[contains(.,'В корзину')][1]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[@href='/cart' ]")
    public WebElement CartButton;

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
