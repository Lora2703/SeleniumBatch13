package com.syntax.review05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitwaitTasks {
    public static String url = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
//        goto the url
//        click on display button after10seconds
//        as soon as the button appears click on it
        WebDriverWait wait = new WebDriverWait(driver,20);

        WebElement button = driver.findElement(By.xpath("//button[@id='display-other-button']"));
        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enabled']")));
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Enabled']"));
        button2.click();
    }
}
