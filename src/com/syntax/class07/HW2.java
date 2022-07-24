package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HW2 {
    /*HW
navigate to http://www.uitestpractice.com/Students/Contact
click on the link
get text
print out in the console*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.uitestpractice.com/Students/Contact");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("This is a Ajax link")).click();

        WebDriverWait wait1 = new WebDriverWait(driver,10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ContactUs']")));

        String text = driver.findElement(By.xpath("//div[@class='ContactUs']")).getText();
        System.out.println(text);

        driver.quit();

    }
}
