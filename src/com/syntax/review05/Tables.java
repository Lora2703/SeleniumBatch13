package com.syntax.review05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Tables {

    public static String url = "https://www.techlistic.com/p/demo-selenium-practice.html";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
//        print the table
//        access the whole table
        WebElement ctable = driver.findElement(By.xpath("//table[@id='customers']"));
//        print the table
        String text = ctable.getText();
//        System.out.println(text);
        //        only print the row that has germany
//        access the rows of the table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
//print all the rows for test
        for(WebElement row:rows){
//            get text from each individual row
            String rowText = row.getText();
           //each row is avaialble for analysis
            if(rowText.contains("Germany")){
                System.out.println(rowText);
            }

        }


//        get all the enteries in the column No 3 i.e country
        List<WebElement> countries = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[3]"));
            for (WebElement country:countries)
            {
                String ctext = country.getText();
                System.out.println(ctext);

            }

//            print all the company names located in UK
//            1.get the column that has country names
        List<WebElement> c3 = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[3]"));
//for loop to traverse and look for UK
         for(WebElement country:c3){
             String countryName = country.getText();
             System.out.println("--------------------------------");
             System.out.println(countryName);
             if(countryName.equals("UK")){

                 System.out.println("print the company ");
             }

         }


    }
}


