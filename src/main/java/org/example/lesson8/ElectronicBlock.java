package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ElectronicBlock {
    private SelenideElement largeAppliancesButton = $(By.xpath("//a[contains(.,'Крупная бытовая техника')]"));

    @Step("Клик на пункт Крупная бытовая техника")
    public void clickLargeAppliancesButton(){
        largeAppliancesButton.click();
    }
}
