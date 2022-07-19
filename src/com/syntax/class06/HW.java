package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
    /*HW
Go to https://syntaxprojects.com/javascript-alert-box-demo.php
click on each button and handle the alert accordingly*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/javascript-alert-box-demo.php");

        driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
        driver.switchTo().alert().dismiss();
        System.out.println(driver.findElement(By.id("confirm-demo")).getText());

        driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
        String name = "Name";
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
        String actualMessage = driver.findElement(By.id("prompt-demo")).getText();
        if(actualMessage.equals("You have entered '"+name+"' !")){
            System.out.println("You have handled prompt correctly");
            System.out.println(actualMessage);
        }else{
            System.out.println("You have handled prompt not correctly");
        }

        driver.quit();
    }
}
