package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW2 {
    /*Go to aa.com/homePage.do
select depart date
select return date
select destination
click on search
quit the browser*/

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://aa.com/homePage.do");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]")).click();

        WebElement departMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
        String departMonthText = departMonth.getText();

        while (!departMonthText.equals("October")){
            WebElement nextMonth = driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
            nextMonth.click();
            departMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            departMonthText = departMonth.getText();
        }

        List<WebElement> departDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement departDate:departDates){
            if (departDate.getText().equals("10")){
                departDate.click();
                break;
            }
        }

        driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();

        WebElement returnMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
        String returnMonthText = returnMonth.getText();

        while (!returnMonthText.equals("November")){
            WebElement nextMonth = driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
            nextMonth.click();
            returnMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            returnMonthText = returnMonth.getText();
        }

        List<WebElement> returnDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement returnDate:returnDates){
            if (returnDate.getText().equals("10")){
                returnDate.click();
                break;
            }
        }

        driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]")).click();

        WebElement selectCountry = driver.findElement(By.id("countryCode"));
        Select select = new Select(selectCountry);
        List<WebElement> options = select.getOptions();
        Iterator<WebElement> iterator = options.iterator();
        while (iterator.hasNext()){
            WebElement country = iterator.next();
            String text = country.getText();
            if(text.equals("Canada")){
                country.click();
            }
        }


        WebElement selectProvinces = driver.findElement(By.id("stateCode"));
        Select selectProvince = new Select(selectProvinces);
        List<WebElement> optionsProvince = selectProvince.getOptions();
        Iterator<WebElement> iteratorProvince = optionsProvince.iterator();
        while (iteratorProvince.hasNext()){
            WebElement province = iteratorProvince.next();
            String text = province.getText();
            if(text.equals("Ontario")){
                province.click();
            }
        }

        List<WebElement> airports = driver.findElements(By.xpath("//table[@id='airportsSection']/tbody/tr"));
        for(int i=0; i<airports.size(); i++){
            if(airports.get(i).getText().contains("Cat Lake")){
                driver.findElement(By.xpath("//table[@id='airportsSection']/tbody/tr["+i+"]/td[3]")).click();
            }
        }

        driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();

        driver.quit();
    }
}
