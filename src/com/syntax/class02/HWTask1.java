package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask1 {
    /*navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
fill out the form
click on register
close the browser*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.manage().window().maximize();
        driver.findElement(By.id("customer.firstName")).sendKeys("FirstName");
        driver.findElement(By.id("customer.lastName")).sendKeys("LastName");
        driver.findElement(By.id("customer.address.street")).sendKeys("Street");
        driver.findElement(By.id("customer.address.city")).sendKeys("City");
        driver.findElement(By.id("customer.address.state")).sendKeys("State");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123456");
        driver.findElement(By.id("customer.ssn")).sendKeys("123");
        driver.findElement(By.id("customer.username")).sendKeys("Username");
        driver.findElement(By.id("customer.password")).sendKeys("Password");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Password");
        driver.findElement(By.className("button")).click();

        driver.quit();

    }
}
