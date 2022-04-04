package org.example.lesson6;

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

    @FindBy(xpath = "//div[@class='bz6']//a[contains(.,'Бытовая техника')]")
    public WebElement appliancesButton;

    public void clickCatalogButton(){
        catalogButton.click();
    }

    public void clickElectronicButton(){
        electronicButton.click();
    }

    public ElectronicBlock electronicBlock;

    public ElectronicBlock clickAppliancesButton(){
        actions.moveToElement(appliancesButton).build().perform();
        return electronicBlock;
    }
}
