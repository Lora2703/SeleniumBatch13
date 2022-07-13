package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TC1 {
   /* TC 1: Facebook dropdown verification
    Open chrome browser
    Go to "https://www.facebook.com"
    click on create new account
    Verify:
    month dd has 12 month options
    day dd has 31 day options
    year dd has 115 year options
    Select your date of birth
    Quit browser*/

    public static final String urlFacebook = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(urlFacebook);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(1000);

        WebElement selectMonth = driver.findElement(By.id("month"));
        Select s1 = new Select(selectMonth);
        List<WebElement> listMonth = s1.getOptions();
        if(listMonth.size()==12){
            System.out.println("month dd has 12 month options");
        }else{
            System.out.println("month dd doesn't have 12 month options");
        }

        WebElement selectDay = driver.findElement(By.id("day"));
        Select s2 = new Select(selectDay);
        List<WebElement> listDays = s2.getOptions();
        if(listDays.size()==31){
            System.out.println("day dd has 31 day options");
        }else{
            System.out.println("day dd doesn't have 31 day options");
        }

        WebElement selectYear = driver.findElement(By.id("year"));
        Select s3 = new Select(selectYear);
        List<WebElement> listYears = s3.getOptions();
        if(listYears.size()==115){
            System.out.println("year dd has 115 year options");
        }else{
            System.out.println("year dd doesn't have 115 year options");
        }

        s1.selectByVisibleText("Mar");
        s2.selectByValue("27");
        s3.selectByValue("1970");

        driver.quit();
    }
}
