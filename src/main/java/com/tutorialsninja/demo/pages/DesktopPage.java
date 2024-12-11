package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProduct;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProductAfterFilter;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement productSorting;

    public String desktopPageTitle() {
        Reporter.log("get desktop page title");
        CustomListener.test.log(Status.PASS,"get desktop page title");
        return getTextFromElement(desktopText);
    }

    public List<WebElement> getListsOfProduct() {
        Reporter.log("get get list od products : "+listOfProduct.toString());
        CustomListener.test.log(Status.PASS,"get get list od products : "+listOfProduct.toString());
        return listOfProduct ;
    }

    public List<WebElement> getListsOfProductAfterFilter() {
        Reporter.log("get get list od products : "+listOfProductAfterFilter.toString());
        CustomListener.test.log(Status.PASS,"get get list od products : "+listOfProductAfterFilter.toString());
        return listOfProductAfterFilter ;
    }

    public void selectSortByZToA(String option) {
        Reporter.log(" product sorting by : "+option);
        CustomListener.test.log(Status.PASS," product sorting by : "+option);
        selectByVisibleTextFromDropDown(productSorting, option);
    }

    public void clickOnYourSelectedProduct(String productName) {
        Reporter.log("Click on : "+productName);
        CustomListener.test.log(Status.PASS,"Click on : "+productName);
        clickOnElement(By.linkText(productName));
    }
}

