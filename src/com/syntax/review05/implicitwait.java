package com.syntax.review05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class implicitwait {

public static String url = "https://syntaxprojects.com/dynamic-data-loading-demo.php";
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//            click on get new user
            WebElement getNewUser = driver.findElement(By.xpath("//button[@type='button']"));
            getNewUser.click();
//            get the username
            WebElement user = driver.findElement(By.xpath("//p[contains (text(),'First Name :')]"));
//                print the username
            System.out.println(user.getText());

        }
}
