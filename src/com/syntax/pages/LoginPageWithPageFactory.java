package com.syntax.pages;

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory extends CommonMethods {

    @FindBy(id = "txtUsername")
    public WebElement username;

    @FindBy(xpath = "//input[@name = 'txtPassword']")
    public WebElement password;

    @FindBy(css = "input#btnLogin")
    public WebElement loginButton;

//    @FindBy(css = "input#btnLogin")
//    public List<WebElement> multipleElements;

    public LoginPageWithPageFactory() {
        PageFactory.initElements(driver, this);
    }

}
