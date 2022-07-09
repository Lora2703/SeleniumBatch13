package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebOrdersTask {
/**
 * Task
 * Navigate to http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx
 * Login
 * Get title and verify
 * logout
 * close the browser
 */
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
    driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
    driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    String actualTitle = driver.getTitle();
    String expectedTitle = "Web Orders";
    if(actualTitle.equals(expectedTitle)){
        System.out.println("Title is correct");
    } else{
        System.out.println("Title is not correct");
    }
    driver.findElement(By.id("ctl00_logout"));
    driver.quit();
}
}

