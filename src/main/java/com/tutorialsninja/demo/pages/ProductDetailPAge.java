package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductDetailPAge extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//h1)[2]")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement dateButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYear;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List<WebElement> selectDate;

    @CacheLookup
    @FindBy(name = "quantity")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btnAddCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement productAddMsg;

    @CacheLookup
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCart;


    public String getPageTitle() {
        Reporter.log("get shopping cart page title");
        CustomListener.test.log(Status.PASS, "get shopping cart page title");
        return getTextFromElement(pageTitle);
    }

    public void selectDate(){
        CustomListener.test.log(Status.PASS,"Select date");
        Reporter.log("Select date");
        sendTextToElement((WebElement) selectDate,"2024-11-27");
    }

    public void enterQuantity(String qty) {
        Reporter.log("get enter quantity : "+qty);
        CustomListener.test.log(Status.PASS, "get enter quantity : "+qty);
        quantity.clear();
        sendTextToElement(quantity, qty);
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Click On Add To Cart Button");
        CustomListener.test.log(Status.PASS, "Click On Add To Cart Button");
        // clickOnElement(btnAddCart);
        mouseHoverToElementAndClick(btnAddCart);
    }

    public String getProductAddToCartSuccessMessage() {
        Reporter.log("Get Product Add To Cart Success Message");
        CustomListener.test.log(Status.PASS, "Get Product Add To Cart Success Message");
        // return waitUntilVisibilityOfElementLocated(productAddMsg, 5).getText();
        return getTextFromElement(productAddMsg);
    }

    public void clickOnShoppingCartLink() {
        Reporter.log("Click on shopping cart");
        CustomListener.test.log(Status.PASS, "Click on shopping cart");
        // clickOnElement(waitUntilVisibilityOfElementLocated(shoppingCart ,2));
        //clickOnElement(shoppingCart);
        mouseHoverToElementAndClick(shoppingCart);
    }

}

