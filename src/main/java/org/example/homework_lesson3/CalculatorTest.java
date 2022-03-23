package org.example.homework_lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalculatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://ipipip.ru/kalkulyator/");

        driver.findElement(By.xpath("//a[@name='one']")).click();

        driver.findElement(By.xpath("//a[@name='plus']")).click();

        driver.findElement(By.xpath("//a[@name='two']")).click();

        driver.findElement(By.xpath("//a[@name='equals']")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}

