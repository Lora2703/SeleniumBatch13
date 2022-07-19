package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    /*Task
Navigate to https://syntaxprojects.com/bootstrap-iframe.php
verify the header text Sorry, We Couldn't Find Anything For "Asksn" is displayed
verify enroll today button is enabled*/
    public static final String urlSyntax = "https://syntaxprojects.com/bootstrap-iframe.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(urlSyntax);

        driver.switchTo().frame("FrameOne");
        String actualText = driver.findElement(By.className("heading-13")).getText();
        if(actualText.equals("Sorry, We Couldn't Find Anything For “Asksn”")){
            System.out.println("Text 'Sorry, We Couldn't Find Anything For “Asksn”' is present");
        } else {
            System.out.println("Text 'Sorry, We Couldn't Find Anything For “Asksn”' is not present");
        }
        driver.switchTo().defaultContent();

        driver.switchTo().frame("FrameTwo");
        if(driver.findElement(By.xpath("//div[text()='Enroll today']")).isEnabled()){
            System.out.println("Button 'Enroll today' is enabled");
        }else{
            System.out.println("Button 'Enroll today' is not enabled");
        }
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
