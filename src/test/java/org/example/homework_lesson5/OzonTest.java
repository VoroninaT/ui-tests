package org.example.homework_lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, ofSeconds(10));
        actions = new Actions(driver);
        driver.get(OZON_BASE_URL);
    }

    @Test
    void hoverCategoryProductTest() throws InterruptedException {
        driver.get(OZON_BASE_URL);
        driver.findElement(By.xpath("//span[text()='Каталог']")).click();
        waitVisibilityOfElementLocated("//span[text()='Электроника']");
        driver.findElement(By.xpath("//span[text()='Электроника']")).click();

        Actions builder = new Actions(driver);
        waitVisibilityOfElementLocated("//div[@class='bz6']//a[contains(.,'Бытовая техника')]");
        WebElement element1 = driver.findElement(By.xpath("//div[@class='bz6']//a[contains(.,'Бытовая техника')]"));
        WebElement element2 = driver.findElement(By.xpath("//a[contains(.,'Крупная бытовая техника')]"));
        builder.moveToElement(element1)
                .click(element2)
                .perform();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.ozon.ru/category/krupnaya-bytovaya-tehnika-10501/");
        Thread.sleep(5000);
    }

    @Test
    void addingProductToCartTest() throws InterruptedException {
        driver.get(OZON_BASE_URL);
        driver.findElement(By.xpath("//span[text()='Каталог']")).click();
        waitVisibilityOfElementLocated("//span[text()='Электроника']");
        driver.findElement(By.xpath("//span[text()='Электроника']")).click();
        waitVisibilityOfElementLocated("//div[@class='bag1']//a[contains(.,'Смартфоны')]");
        driver.findElement(By.xpath("//div[@class='bag1']//a[contains(.,'Смартфоны')]")).click();
        waitVisibilityOfElementLocated("//button[contains(.,'В корзину')][1]");
        driver.findElement(By.xpath("//button[contains(.,'В корзину')][1]")).click();
        driver.findElement(By.xpath("//a[@href='/cart' ]")).click();
        WebElement GoToFormalization = driver.findElement(By.xpath("(//div[.='Перейти к оформлению']/button)[1]"));
        Assertions.assertNotNull(GoToFormalization);

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    protected void waitVisibilityOfElementLocated(String xPath){
        wait.until(visibilityOfElementLocated(By.xpath(xPath)));
    }
}

