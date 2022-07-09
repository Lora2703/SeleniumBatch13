package com.syntax.class03;
/*HW
Navigate to http://syntaxprojects.com
Click on start practicing
click on simple form demo
enter any text on first text box
click on show message
quit the browser*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://syntaxprojects.com");
        driver.findElement(By.id("btn_basic_example")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Simple Form Demo']")).click();
        driver.findElement(By.id("user-message")).sendKeys("Message");
        driver.quit();
    }
}
