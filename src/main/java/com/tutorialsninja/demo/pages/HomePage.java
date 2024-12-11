package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.utilities.Utility;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {


    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNotBook;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;

    @CacheLookup
    @FindBy(xpath = "//button[@class=\"btn btn-link dropdown-toggle\"]")
    WebElement currency;

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//li//a")
    List<WebElement> topMenuList;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement btnPound;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    WebElement selectPound;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> listOfAccountOption;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccount;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountForLogOut;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement LogOut;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement btnContinue;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement Components;

    public String getPageTitleOfComponents() {
        Reporter.log("get components page title");
        CustomListener.test.log(Status.PASS,"get components page title");
        return getTextFromElement(Components);
    }


    public List<WebElement> getTopMenuList() {
        Reporter.log("get top menu list : " + topMenuList.toString());
        CustomListener.test.log(Status.PASS, "get top menu list : " + topMenuList.toString());
        return topMenuList;
    }

    public void clickOnMenuOption(String name) {
        Reporter.log("click on : " + name);
        CustomListener.test.log(Status.PASS, "click on : " + name);
        clickOnElement(By.linkText(name));
    }

    public void mouseHoverOnDesktop() {
        Reporter.log("mouse hover on desktop");
        CustomListener.test.log(Status.PASS, "mouse hover on desktop");
        mouseHoverToElement(desktop);
    }

    public void mouseHoverOnLaptopAndNotBook() {
        Reporter.log("mouse hover on laptop and not book");
        CustomListener.test.log(Status.PASS, "mouse hover on laptop and not book");
        mouseHoverToElement(laptopAndNotBook);
    }

    public void mouseHoverOnComponents() {
        Reporter.log("mouse hover on components");
        CustomListener.test.log(Status.PASS, "mouse hover on components");
        mouseHoverToElement(components);
    }

    public void mouseHoverOnCurrencyAndClick() {
        Reporter.log("Mouse Hover On Currency And Click On that");
        CustomListener.test.log(Status.PASS, "Mouse Hover On Currency And Click On that");
        mouseHoverToElementAndClick(currency);
    }

    public void selectCurrencyAsAPound(String option) {
        Reporter.log("Select Currency As APound");
        CustomListener.test.log(Status.PASS, "Select Currency As APound");
        // selectByContainsTextFromDropDown(selectPound, option);
        clickOnElement(btnPound);
    }

    public List<WebElement> getListOfMyAccountOption() {
        Reporter.log("get list of my account option : " + listOfAccountOption);
        CustomListener.test.log(Status.PASS, "get list of my account option : " + listOfAccountOption);
        return listOfAccountOption;
    }

    public void clickOnMyAccount() {
        Reporter.log("Click on may account");
        CustomListener.test.log(Status.PASS, "Click on may account");
        clickOnElement(myAccount);
    }

    public void clickOnMyAccountForLogOut() {
        Reporter.log("Click on may account");
        CustomListener.test.log(Status.PASS, "Click on may account");
        clickOnElement(myAccountForLogOut);
    }

    public void clickOnLogOut(String txt) {
        Reporter.log("Click on log out");
        CustomListener.test.log(Status.PASS, "Click on log out");
        driver.findElement(By.linkText(txt)).click();
    }

    public String getConfirmationMessageOfLogout() {
        Reporter.log("get log out confirmation message");
        CustomListener.test.log(Status.PASS, "get log out confirmation message");
        return getTextFromElement(LogOut);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button");
        CustomListener.test.log(Status.PASS, "Click on continue button");
        clickOnElement(btnContinue);
    }

}

