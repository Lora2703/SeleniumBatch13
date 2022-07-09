package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HWTask2 {
    /*TC 1: Amazon link count:
Open chrome browser
Go to "https://www.amazon.com/"
Get all links
Get number of links that has text
Print to console only the links that has text*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of all links: "+allLinks.size());
        for(int i=0; i<allLinks.size(); i++){
            if(allLinks.get(i).getText().isEmpty()){
                allLinks.remove(i);
            }
        }
        System.out.println("Number of links that have text: "+allLinks.size());
        driver.quit();

    }
}
