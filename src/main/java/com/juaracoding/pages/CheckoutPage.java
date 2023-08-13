package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;
    JavascriptExecutor js;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//a[normalize-space()='View cart']")
    WebElement btnViewCart;

    @FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
    WebElement btnCO;

    @FindBy(id = "billing_first_name")
    WebElement firstName;

    @FindBy(id = "billing_last_name")
    WebElement lastName;

    @FindBy(id = "billing_company")
    WebElement company;

    @FindBy(id = "select2-billing_country-container")
    WebElement country;

    @FindBy(xpath = "//input[@role='combobox']")
    WebElement searchCountry;

    @FindBy(id="billing_address_1")
    WebElement address;

    @FindBy(id="billing_city")
    WebElement city;

    @FindBy(id="select2-billing_state-container")
    WebElement province;

    @FindBy(xpath = "//input[@role='combobox']")
    WebElement searchProvince;

    @FindBy(id="billing_postcode")
    WebElement postCode;

    @FindBy(id="billing_phone")
    WebElement phone;

    @FindBy(id="order_comments")
    WebElement orderNotes;

    @FindBy(className="woocommerce-terms-and-conditions-checkbox-text")
    WebElement terms;

    @FindBy(id="place_order")
    WebElement btnOrder;

    @FindBy(className = "woocommerce-error")
    WebElement txtErrorCheckbox;

    @FindBy(className = "woocommerce-thankyou-order-received")
    WebElement txtOrder;


    public void checkout(){
        btnViewCart.click();
        js.executeScript("window.scrollBy(0,800)");
        btnCO.click();
        js.executeScript("window.scrollBy(0,500)");
    }
    public void clear(){
        firstName.clear();
        lastName.clear();
        company.clear();
        address.clear();
        city.clear();
        postCode.clear();
        phone.clear();
    }

    public void checkoutForm(){
        firstName.sendKeys("Qurrotul");
        lastName.sendKeys("Aini");
        company.sendKeys("Juara Coding");
        country.click();
        searchCountry.sendKeys("Indonesia" + Keys.ENTER);
        address.sendKeys("Jl. in aja dulu No. 198");
        city.sendKeys("Jakarta Utara");
        province.click();
        searchProvince.sendKeys("DKI Jakarta" + Keys.ENTER);
        postCode.sendKeys("14260");
        phone.sendKeys("081234567890 ");
        orderNotes.sendKeys("yang pedes karetnya dua");

    }

    public void checkbox(boolean checkbox){
        if (checkbox){
            js.executeScript("window.scrollBy(0,500)");
            terms.click();
            btnOrder.click();
        }
        else {
            btnOrder.click();
        }
    }

    public String orderTxt(){
        return txtOrder.getText();
    }

    public String errorTxt(){
        return txtErrorCheckbox.getText();
    }
}
