package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartphonesPage extends BaseView {

    public SmartphonesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='a4gb ab9f']//a[contains(.,'Смартфоны')]")
    public WebElement smartphonesButton;

    @FindBy(xpath = "//button[contains(.,'В корзину')][1]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[@href='/cart' ]")
    public WebElement CartButton;

    public  void clickSmartphonesButton(){
        smartphonesButton.click();
    }

    public  void clickAddToCartButton(){
        addToCartButton.click();
    }

    public  void clickCartButton(){
        CartButton.click();
    }
}
