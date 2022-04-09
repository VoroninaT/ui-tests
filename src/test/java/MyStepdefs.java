import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.lesson8.CategoryProductPage;
import org.example.lesson8.SmartphonesPage;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {

    @Given("Войти на сайт")
    public void enterTheSite() {
        open("https://www.ozon.ru/");
    }

    @When("Кликаю на кнопку Каталог")
    public void clickCatalogButton() {
        new CategoryProductPage().clickCatalogButton();
    }

    @And("Кликаю на кнопку Электроника")
    public void clickElectronicButton() {
        new CategoryProductPage().clickElectronicButton();
    }

    @And("Кликаю на  Смартфоны")
    public void clickButtonSmartphones() {
        new SmartphonesPage().clickSmartphonesButton();
    }

    @And("Кликаю на кнопку В корзину")
    public void clickAddToCartButton() {
        new SmartphonesPage().clickAddToCartButton();
    }

    @Then("Проверяем наличие товара в корзине")
    public void clickButtonToCart() {
        new SmartphonesPage().clickCartButton();
    }
}
