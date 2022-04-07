package org.example.homework_lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.example.lesson6.CategoryProductPage;
import org.example.lesson6.SmartphonesPage;
import org.example.lesson7.CustomLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class OzonTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    private  final static  String OZON_BASE_URL = "https://www.ozon.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate( new ChromeDriver());
        wait = new WebDriverWait(driver, ofSeconds(10));
        actions = new Actions(driver);
        driver.get(OZON_BASE_URL);
    }

    @Test
    void hoverCategoryProductTest() throws InterruptedException {
        driver.get(OZON_BASE_URL);

        CategoryProductPage categoryProductPage = new CategoryProductPage(driver);
        categoryProductPage.clickCatalogButton();
        waitVisibilityOfElementLocated("//span[text()='Электроника']");
        categoryProductPage.clickElectronicButton();
        waitVisibilityOfElementLocated("//div[@class='d2c']//a[contains(.,'Бытовая техника')]");
        categoryProductPage.clickAppliancesButton()
                .clickLargeAppliancesButton();

       Assertions.assertEquals(driver.getCurrentUrl(), "https://www.ozon.ru/category/krupnaya-bytovaya-tehnika-10501/");
    }

    @Test
    void addingProductToCartTest() throws InterruptedException {
        driver.get(OZON_BASE_URL);

        CategoryProductPage categoryProductPage = new CategoryProductPage(driver);
        categoryProductPage.clickCatalogButton();
        waitVisibilityOfElementLocated("//span[text()='Электроника']");
        categoryProductPage.clickElectronicButton();

        SmartphonesPage smartphonesPage = new SmartphonesPage(driver);
        waitVisibilityOfElementLocated("//div[@class='gba4']//a[contains(.,'Смартфоны')]");
        smartphonesPage.clickSmartphonesButton();
        waitVisibilityOfElementLocated("//div[@class='ui-b1']//button[contains(.,'В корзину')][1]");
        smartphonesPage.clickAddToCartButton();
        smartphonesPage.clickCartButton();
    }

    @AfterEach
    void tearDown() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }

        driver.quit();
    }

    protected void waitVisibilityOfElementLocated(String xPath){
        wait.until(visibilityOfElementLocated(By.xpath(xPath)));
    }
}

