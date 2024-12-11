package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPAge extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//h1)[2]")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement productModel;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQuantity;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement messageOfProductUpdate;

    public String getShoppingCartPageTitle() {
        Reporter.log("get shopping cart page title");
        CustomListener.test.log(Status.PASS, "get shopping cart page title");
        return getTextFromElement(pageTitle);
    }

    public String getProductName() {
        Reporter.log("Get Product Name : "+ productName);
        CustomListener.test.log(Status.PASS, "Get Product Name : "+ productName);
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }

    public String getProductModel() {
        Reporter.log("Get Product model : "+ productModel);
        CustomListener.test.log(Status.PASS, "Get Product model : "+ productModel);
        return getTextFromElement(productModel);
    }

    public String getProductTotalPrise() {
        Reporter.log("Get Product total price : "+ totalPrice);
        CustomListener.test.log(Status.PASS, "Get Product total price : "+ totalPrice);
        return getTextFromElement(totalPrice);
    }

    public void changeQuantity(String qty) {
        Reporter.log("Change product quantity : " +qty);
        CustomListener.test.log(Status.PASS, "Change product quantity : " +qty);
        changeQuantity.clear();
        sendTextToElement(changeQuantity, qty);
    }

    public void clickOnUpdateButton() {
        Reporter.log("Click On Update Button");
        CustomListener.test.log(Status.PASS, "Click On Update Button");
        clickOnElement(updateBtn);
    }

    public String getProductUpdateSuccessMessage() {
        Reporter.log("Get Product Update Success Message");
        CustomListener.test.log(Status.PASS, "Get Product Update Success Message");
        return getTextFromElement(messageOfProductUpdate);
    }

}

