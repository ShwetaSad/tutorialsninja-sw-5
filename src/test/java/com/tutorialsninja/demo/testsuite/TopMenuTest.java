package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopAndNotebookPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(CustomListener.class)
public class TopMenuTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopsPage;
    LaptopAndNotebookPage notebooksPage;


    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        desktopsPage = new DesktopPage();
        notebooksPage = new LaptopAndNotebookPage();
    }


        public void selectMenu(String menu) {
            clickOnElement(By.linkText(menu));
        }


    @Test(groups = "sanity")
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnDesktop();
        selectMenu("Show AllDesktops");
        Assert.assertEquals(desktopsPage.desktopPageTitle(), "Desktops",
                "Not navigate to Desktop page");
    }

    @Test(groups = "smoke")
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopAndNotBook();
        selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(notebooksPage.getTitleOfLaptopAndNotBookPage(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponents();
        selectMenu("Show AllComponents");
        Assert.assertEquals(homePage.getPageTitleOfComponents(), "Components",
                "Not navigate to Components page");
    }

}

