package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HW1 {
    /*HW
Go to https://demoqa.com/browser-windows
click on New Tab and print the text from new tab in the console
click on New Window and print the text from new window in the console
click on New Window Message and print the text from new window in the console
Verify (compare) the titles for each page
Print out the title of the all pages
*/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        String mainPageHandle = driver.getWindowHandle();

        List<String> text = new ArrayList<>();

        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("windowButton")).click();

        Set<String> allWindowsHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowsHandles.iterator();
        while (iterator.hasNext()){
            String handle = iterator.next();
            if(!mainPageHandle.equals(handle)){
                driver.switchTo().window(handle);
                String txt = driver.findElement(By.xpath("//h1")).getText();
                text.add(txt);
                System.out.println(txt);
                driver.close();
            }
        }
        driver.switchTo().window(mainPageHandle);

        driver.findElement(By.id("messageWindowButton")).click();
        Set<String> allWindowsHandles1 = driver.getWindowHandles();
        Iterator<String> it = allWindowsHandles1.iterator();
        mainPageHandle = it.next();
        String childPageHandle = it.next();
        driver.switchTo().window(childPageHandle);
        String txt = driver.findElement(By.tagName("body")).getText();
        text.add(txt);
        System.out.println(txt);
        driver.close();
        driver.switchTo().window(mainPageHandle);

        for(int i=0; i<text.size()-1; i++){
            if(text.get(i).equals(text.get(i+1))){
                System.out.println("Text on pages is equal");
            } else {
                System.out.println("Text on pages isn't equal");
            }
        }
        for(String t:text){
            System.out.println(t);
        }
        driver.quit();

    }
}
