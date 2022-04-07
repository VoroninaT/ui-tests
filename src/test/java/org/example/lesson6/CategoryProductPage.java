package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryProductPage extends BaseView {

    public CategoryProductPage(WebDriver driver) {
        super(driver);
        electronicBlock = new ElectronicBlock(driver);
    }

    @FindBy(xpath = "//span[text()='Каталог']")
    public WebElement catalogButton;

    @FindBy(xpath = "//span[text()='Электроника']")
    public WebElement electronicButton;

    @FindBy(xpath = "//div[@class='d2c']//a[contains(.,'Бытовая техника')]")
    public WebElement appliancesButton;

    @Step("Клик на кнопку Каталог")
    public void clickCatalogButton(){
        catalogButton.click();
    }

    @Step("Клик на кнопку Электроника")
    public void clickElectronicButton(){
        electronicButton.click();
    }

    public ElectronicBlock electronicBlock;

    @Step("Наведение мышкой на пункт Бытовая техника")
    public ElectronicBlock clickAppliancesButton(){
        actions.moveToElement(appliancesButton).build().perform();
        return electronicBlock;
    }
}
