package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement loginPageTile;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement btnLogin;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountPageTile;

    public String getMyAccountPageTitle() {
        Reporter.log("get my account page title ");
        CustomListener.test.log(Status.PASS, "get my account page title ");
        return getTextFromElement(myAccountPageTile);
    }
    public String getLoginPageTitle() {
        Reporter.log("get login page title");
        CustomListener.test.log(Status.PASS, "get login page title");
        return getTextFromElement(loginPageTile);
    }

    public void enterEmail(String mail) {
        Reporter.log("Enter email : " + mail);
        CustomListener.test.log(Status.PASS, "Enter email : " + mail);
        sendTextToElement(email, mail);
    }

    public void enterPassword(String pass) {
        Reporter.log("Enter password : " + pass);
        CustomListener.test.log(Status.PASS, "Enter password : " + pass);
        sendTextToElement(password, pass);
    }

    public void clickOnLogInButton() {
        Reporter.log("Click on log in button");
        CustomListener.test.log(Status.PASS, "Click on log in button");
        clickOnElement(btnLogin);
    }
}

