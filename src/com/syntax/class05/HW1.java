package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW1 {

    /*HW1
Go to facebook sign up page
Fill out the whole form
Click signup*/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(TC1.urlFacebook);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("First");
        driver.findElement(By.name("lastname")).sendKeys("Last");
        driver.findElement(By.name("reg_email__")).sendKeys("email");
        driver.findElement(By.name("reg_passwd__")).sendKeys("password");

        WebElement selectMonth = driver.findElement(By.id("month"));
        Select s1 = new Select(selectMonth);
        s1.selectByVisibleText("Mar");

        WebElement selectDay = driver.findElement(By.id("day"));
        Select s2 = new Select(selectDay);
        s2.selectByValue("28");

        WebElement selectYear = driver.findElement(By.id("year"));
        Select s3 = new Select(selectYear);
        s3.selectByValue("1999");

        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.name("websubmit")).submit();

        driver.quit();

    }
}
