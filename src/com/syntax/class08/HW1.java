package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW1 {
    /*go to https://the-internet.herokuapp.com/dynamic_controls
click on checkbox and click on remove
verify the text
click on enable verify the textbox is enabled
enter text and click disable
verify the textbox is disabled*/

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        String actualText = driver.findElement(By.xpath("//p[@id='message']")).getText();
        String expectedText = "It's gone!";
        if(actualText.equals(expectedText)){
            System.out.println("It's gone!");
        }else{
            System.out.println("Something went wrong");
        }

        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        if(driver.findElement(By.xpath("//input[@type='text']")).isEnabled()){
            System.out.println("Textbox is enabled");
        }
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Text");
        driver.findElement(By.xpath("//button[text()='Disable']")).click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//p[@id='message']"), "It's disabled!"));
        if(driver.findElement(By.xpath("//p[@id='message']")).getText().equals("It's disabled!")){
            System.out.println("Textbox is disabled");
        }

                driver.quit();
    }
}
