package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW2 {
    /*HW2
Go to ebay.com
get all the categories and print them in the console
select Computers/Tables & Networking
click on search
verify the header*/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://ebay.com");
        WebElement allCategories = driver.findElement(By.id("gh-cat"));
        Select select = new Select(allCategories);
        List<WebElement> listAllCategories = select.getOptions();
        for(WebElement element:listAllCategories){
            System.out.println(element.getText());
        }
        allCategories.click();
        Thread.sleep(2000);
        select.selectByValue("58058");

        driver.findElement(By.id("gh-btn")).click();
        String actualTitle = driver.getTitle();
        if(actualTitle.contains("Computers, Laptops")){
            System.out.println("The title is correct");
        }else{
            System.out.println("The title is not correct");
        }
        driver.quit();
    }
}
