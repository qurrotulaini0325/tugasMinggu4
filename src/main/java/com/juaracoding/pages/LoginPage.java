package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;


    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Dismiss']")
    WebElement dismiss;

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    WebElement myAcc;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(name = "login")
    WebElement btnLogin;

    @FindBy(className = "woocommerce-MyAccount-content")
    WebElement txtLogin;

    public void login(){
        dismiss.click();
        myAcc.click();
        username.sendKeys("qurrotulaini0325@gmail.com");
        password.sendKeys("juaracoding2023");
        btnLogin.click();
    }

    public String loginTxt(){
        return txtLogin.getText();
    }

}
