package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddToCartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class MainApp {

    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        System.out.println("Test Login :");
        DriverSingleton.contains(loginPage.loginTxt(), "Hello");

        AddToCartPage addToCartPage = new AddToCartPage();
        addToCartPage.cart();
        System.out.println("Test Add to Cart :");
        DriverSingleton.contains(addToCartPage.cartTxt(),"has been added to your cart");

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkout();
        checkoutPage.clear();

        System.out.println("Test Checkout :");
        checkoutPage.checkoutForm();
        checkoutPage.checkbox(false);
        DriverSingleton.contains(checkoutPage.errorTxt(),"Your order has been received.");

        checkoutPage.checkbox(true);
        DriverSingleton.contains(checkoutPage.orderTxt(),"Your order has been received.");

        driver.quit();
        System.out.println("Quit browser");
    }
}