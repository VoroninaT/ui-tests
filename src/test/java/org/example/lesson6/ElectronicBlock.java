package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicBlock extends BaseView {

    public ElectronicBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(.,'Крупная бытовая техника')]")
    public WebElement largeAppliancesButton;

    public void clickLargeAppliancesButton(){
        largeAppliancesButton.click();
    }
}
