package com.syntax.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    private WebDriver driver;

    public WebDriver openBrowser(String url){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return driver;
    }

    public void quitBrowser(){
        if(driver != null){
            driver.quit();
        }
    }
}
