package org.example.homework_lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class InvoltaTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://involta.ru/tools/length-chars/");

        driver.findElement(By.xpath("//textarea[@placeholder='Вставте текст']")).click();


        int length = new Random().ints(1, 100)
                .findFirst()
                .getAsInt();
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Вставте текст']")));

        driver.findElement(By.xpath("//textarea[@placeholder='Вставте текст']")).sendKeys(generatedString);

        driver.findElement(By.xpath("//button[@class='main-button']")).click();
        Thread.sleep(5000);

        driver.quit();
    }
}
