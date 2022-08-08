package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW1 {
    /*Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
click on leave
click on leave list
choose from "From calendar"
choose from "To calendar"
click only on cancelled and rejected checkboxes
uncheck Pending Approval
select IT support from DD
click search
quit the browser
*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.id("menu_leave_viewLeaveList")).click();

        driver.findElement(By.id("calFromDate")).click();
        WebElement fromMonth = driver.findElement(By.className("ui-datepicker-month"));
        Select selectFrom = new Select(fromMonth);
        selectFrom.selectByVisibleText("Mar");

        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement fromDate:fromDates){
            if(fromDate.getText().equals("14")){
                fromDate.click();
                break;
            }
        }

        driver.findElement(By.id("calToDate")).click();
        WebElement toMonth = driver.findElement(By.className("ui-datepicker-month"));
        Select selectTo = new Select(toMonth);
        selectTo.selectByVisibleText("Jun");

        List<WebElement> toDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement toDate:toDates){
            if(toDate.getText().equals("28")){
                toDate.click();
                break;
            }
        }

        List<WebElement> checkboxes = driver.findElements(By.id("leaveList_chkSearchFilter_checkboxgroup"));
        for(WebElement checkbox:checkboxes){
            if(checkbox.getText().equals("Rejected")||checkbox.getText().equals("Cancelled")||checkbox.getText().equals("Pending Approval")){
                checkbox.click();
            }
        }

        WebElement sU = driver.findElement(By.id("leaveList_cmbSubunit"));
        Select selectSU = new Select(sU);
        selectSU.selectByVisibleText("IT Support");
        driver.findElement(By.id("btnSearch")).click();

        driver.quit();
    }
}
