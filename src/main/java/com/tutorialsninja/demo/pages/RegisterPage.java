package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement phoneNumber;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subScribe;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement btnContinue;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement confirmationMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueConfirmation;


    public String getRegisterAccountTitle() {
        Reporter.log("get register account page title");
        CustomListener.test.log(Status.PASS, "get register account page title");
        return getTextFromElement(pageTitle);
    }

    public void enterFirstName(String firstname) {
        Reporter.log("Enter first name : "+ firstname);
        CustomListener.test.log(Status.PASS, "Enter first name : "+ firstname);
        sendTextToElement(firstName, firstname);
    }

    public void enterLastName(String lastNmae) {
        Reporter.log("Enter last name : "+ lastNmae);
        CustomListener.test.log(Status.PASS, "Enter last name : "+ lastNmae);
        sendTextToElement(lastName, lastNmae);
    }

    public void enterEmail(String mail) {
        Reporter.log("Enter email : "+ mail);
        CustomListener.test.log(Status.PASS, "Enter email : "+ mail);
        sendTextToElement(email, mail);
    }

    public void enterPhoneNumber(String number) {
        Reporter.log("Enter phone number : "+ number);
        CustomListener.test.log(Status.PASS, "Enter phone number : "+ number);
        sendTextToElement(phoneNumber, number);
    }

    public void enterPassword(String pass) {
        Reporter.log("Enter password : "+ pass);
        CustomListener.test.log(Status.PASS, "Enter password : "+ pass);
        sendTextToElement(password, pass);
    }

    public void enterConfirmPassword(String cPass) {
        Reporter.log("Enter confirm password : "+ cPass);
        CustomListener.test.log(Status.PASS, "Enter confirm password : "+ cPass);
        sendTextToElement(confirmPassword, cPass);
    }

    public void selectSubscribe(String option) {
        Reporter.log("select Subscribe as : "+option);
        CustomListener.test.log(Status.PASS, "select Subscribe as : "+option);
      //  selectByVisibleTextFromDropDown(subScribe,option);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log("Click On Privacy Policy CheckBox");
        CustomListener.test.log(Status.PASS, "Click On Privacy Policy CheckBox");
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click On Continue Button");
        CustomListener.test.log(Status.PASS, "Click On Continue Button");
        clickOnElement(btnContinue);
    }

    public String getAccountRegistrationConformationMessage() {
        Reporter.log("Get Account Registration Conformation Message");
        CustomListener.test.log(Status.PASS, "Get Account Registration Conformation Message");
        return getTextFromElement(confirmationMessage);
    }

    public void clickOnContinueWithConfirmation() {
        Reporter.log("Click On Continue button With Confirmation");
        CustomListener.test.log(Status.PASS, "Click On Continue button With Confirmation");
        clickOnElement(continueConfirmation);
    }

}


