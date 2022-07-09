package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWTask2 {
    /*navigate to fb.com
click on create new account
fill up all the textboxes
click on sign up button
close the pop up
close the browser*/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
   //     Thread.sleep(10000);
        driver.findElement(By.id("u_0_0_UC")).click();
        driver.findElement(By.id("u_9_b_LV")).sendKeys("FirstName");
        driver.findElement(By.id("u_9_d_IR")).sendKeys("LastName");
        driver.findElement(By.id("u_9_g_fM")).sendKeys("123456");
        driver.findElement(By.id("password_step_input")).sendKeys("Password");
        driver.findElement(By.id("u_9_s_D8")).click();
        driver.findElement(By.id("u_9_9_Bk")).click();
        driver.quit();


    }
}
