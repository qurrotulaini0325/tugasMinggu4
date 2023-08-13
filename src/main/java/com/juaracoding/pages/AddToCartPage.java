package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddToCartPage {
    private WebDriver driver;
    JavascriptExecutor js;


    public AddToCartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    @FindBy(className = "cart-button")
    WebElement btnCart;

    @FindBy(xpath = "//a[@class='button wc-backward']")
    WebElement btnReturn;

    @FindBy(className = "noo-product-inner")
    WebElement product;

    @FindBy(id = "pa_color")
    WebElement color;

    @FindBy(id= "pa_size")
    WebElement size;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement btnAdd;

    @FindBy(className = "woocommerce-message")
    WebElement txtCart;

    public void cart(){
        btnCart.click();
        js.executeScript("window.scrollBy(0,500)");
        btnReturn.click();
        product.click();
        js.executeScript("window.scrollBy(0,500)");
        select();

        js.executeScript("window.scrollBy(0,500)");
        product.click();
        js.executeScript("window.scrollBy(0,500)");
        select();

    }

    public void select(){
        Select selectColor = new Select(color);
        selectColor.selectByIndex(1);
        Select selectSize = new Select(size);
        selectSize.selectByIndex(2);
        btnAdd.click();
    }
    public String cartTxt(){
        return txtCart.getText();
    }

}
