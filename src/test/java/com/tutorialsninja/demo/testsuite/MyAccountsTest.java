package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LoginPage;
import com.tutorialsninja.demo.pages.RegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(CustomListener.class)
public class MyAccountsTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();

    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = homePage.getListOfMyAccountOption();
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = homePage.getListOfMyAccountOption();
        }
    }

    @Test(groups = "sanity")
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnMyAccount();
        selectMyAccountOptions("Register");
        Assert.assertEquals(registerPage.getRegisterAccountTitle(), "Register Account",
                "Register page not displayed");
    }

    @Test(groups = "smoke")
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        homePage.clickOnMyAccount();

        selectMyAccountOptions("Login");

        Assert.assertEquals(loginPage.getLoginPageTitle(), "Returning Customer",
                "Login page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        homePage.clickOnMyAccount();

        selectMyAccountOptions("Register");

        registerPage.enterFirstName("shaveta");
        registerPage.enterLastName("Sethi");
        registerPage.enterEmail("sadhwani@gmail.com");
        registerPage.enterPhoneNumber("0734353463");
        registerPage.enterPassword("sethi123");
        registerPage.enterConfirmPassword("sethi123");
        registerPage.selectSubscribe("Yes");
        registerPage.clickOnPrivacyPolicyCheckBox();
        registerPage.clickOnContinueButton();

        Assert.assertEquals(registerPage.getAccountRegistrationConformationMessage(),
                "Your Account Has Been Created!", "Your Account Not Created!");

        registerPage.clickOnContinueWithConfirmation();
        Thread.sleep(2000);

        homePage.clickOnMyAccountForLogOut();

        homePage.clickOnLogOut("Logout");
        Thread.sleep(2000);

        Assert.assertEquals(homePage.getConfirmationMessageOfLogout(),
                "Account Logout", "Not logged out");

        homePage.clickOnContinueButton();
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyAccount();

        selectMyAccountOptions("Login");

        loginPage.enterEmail("prime1233@gmail.com");

        loginPage.enterPassword("test1234");

        loginPage.clickOnLogInButton();

        Assert.assertEquals(loginPage.getMyAccountPageTitle(), "My Account",
                "My Account Is not Matched!");

        homePage.clickOnMyAccountForLogOut();

        homePage.clickOnLogOut("Logout");

        Assert.assertEquals(homePage.getConfirmationMessageOfLogout(),
                "Account Logout", "Not logged out");

        homePage.clickOnContinueButton();

    }

}

