package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductDetailPAge;
import com.tutorialsninja.demo.pages.ShoppingCartPAge;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.ArrayList;
import java.util.Collections;

@Listeners(CustomListener.class)
public class DeskTopsTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopsPage;
    ProductDetailPAge productDetailPAge;
    ShoppingCartPAge cartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        desktopsPage = new DesktopPage();
        productDetailPAge = new ProductDetailPAge();
        cartPage = new ShoppingCartPAge();
    }

    @Test(groups = "sanity")
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        //1.1 Mouse hover on Desktops Tab. and click
        homePage.mouseHoverOnDesktop();

        //1.2 Click on “Show All Desktops”
        homePage.clickOnMenuOption("Show AllDesktops");

        //1.3 Select Sort By position "Name: Z to A"

        desktopsPage.selectSortByZToA(" (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.

        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListsOfProduct()) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);


        Thread.sleep(3000);
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListsOfProductAfterFilter()) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

        Assert.assertEquals(afterSortByZToAProductsName, originalProductsName,
                "Product not sorted into Z to A order");
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "productDetails", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully
            (String product, String qty, String successMessage, String productName, String model, String total) throws InterruptedException {

        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyAndClick();

        //2.2 Mouse hover on £Pound Sterling and click
        homePage.selectCurrencyAsAPound("£Pound Sterling");

        //2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverOnDesktop();

        //2.4 Click on “Show All Desktops”
        homePage.clickOnMenuOption("Show AllDesktops");

        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.selectSortByZToA("Name (A - Z)");

        //2.6 Select product <product>
        desktopsPage.clickOnYourSelectedProduct(product);

        //2.7 Enter Qty <qty> using Select class.
        productDetailPAge.enterQuantity(qty);

        //2.8 Click on “Add to Cart” button
        productDetailPAge.clickOnAddToCartButton();

        //2.9 Verify the Message <successMessage>
        Assert.assertTrue(productDetailPAge.getProductAddToCartSuccessMessage()
                        .contains(successMessage),
                "Product not added to cart");
        Thread.sleep(2000);

        //2.10 Click on link “shopping cart” display into success message
        productDetailPAge.clickOnShoppingCartLink();
        Thread.sleep(2000);

        //2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(cartPage.getShoppingCartPageTitle().contains("Shopping Cart"));

        //2.12 Verify the Product name <productName>
        Assert.assertTrue(cartPage.getProductName().equalsIgnoreCase(productName),
                "Product name not matched");

        //2.13 Verify the Model <model>
        Assert.assertTrue(cartPage.getProductModel().equalsIgnoreCase(model),
                "Model not matched");

        //2.14 Verify the Total
        Assert.assertEquals(cartPage.getProductTotalPrise(), total,
                "Total not matched");
    }

}


