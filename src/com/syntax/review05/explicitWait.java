package com.syntax.review05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class explicitWait {
    public static String url = "http://syntaxprojects.com/dynamic-elements-loading.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//         initialize the wait
        WebDriverWait wait = new WebDriverWait(driver, 20);
//        click on the button
        WebElement button = driver.findElement(By.xpath("//button[@id='startButton']"));
        button.click();
//        the conditional wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Welcome Syntax Technologies']")));
//        get thetext Welcome syntax Tech
        WebElement text = driver.findElement(By.xpath("//h4[text()='Welcome Syntax Technologies']"));
        System.out.println(text.getText());

    }
}
