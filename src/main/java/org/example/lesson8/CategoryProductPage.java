package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CategoryProductPage {
    private SelenideElement catalogButton = $(By.xpath("//span[text()='Каталог']"));

    private  SelenideElement electronicButton = $(By.xpath("//span[text()='Электроника']"));

    private  SelenideElement appliancesButton = $(By.xpath("//div[@class='d2c']//a[contains(.,'Бытовая техника')]"));

    @Step
    public void clickCatalogButton(){
        catalogButton.click();
    }

    @Step
    public void clickElectronicButton() {
        electronicButton.click();
    }

    public ElectronicBlock electronicBlock;

    @Step("Наведение мышкой на пункт Бытовая техника")
    public ElectronicBlock clickAppliancesButton(){
        appliancesButton.hover();
        return electronicBlock;
    }
}
