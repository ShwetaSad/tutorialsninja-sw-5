package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListener;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopAndNotebookPage;
import com.tutorialsninja.demo.pages.ProductDetailPAge;
import com.tutorialsninja.demo.pages.ShoppingCartPAge;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListener.class)
public class LaptopsAndNotebooksTest {
    HomePage homePage;
    LaptopAndNotebookPage notebooksPage;
    ProductDetailPAge detailPage;
    ShoppingCartPAge cartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        notebooksPage = new LaptopAndNotebookPage();
        detailPage = new ProductDetailPAge();
        cartPage = new ShoppingCartPAge();
    }

    @Test(groups = "sanity")
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopAndNotBook();

        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnMenuOption("Show AllLaptops & Notebooks");

        //1.3 Select Sort By "Price (High > Low)"
        notebooksPage.selectSortByZToA("Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : notebooksPage.getListsOfProductPrice()) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);

        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : notebooksPage.getListsOfProductPriceAfterFilter()) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(afterSortByPrice);

        Assert.assertEquals(afterSortByPrice, originalProductsPrice,
                "Product not sorted by price High to Low");

    }

    @Test(groups = "smoke")
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
         //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopAndNotBook();
        homePage.clickOnMenuOption("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        notebooksPage.selectSortByZToA("Price (High > Low)");

        //2.4 Select Product “MacBook”
        notebooksPage.clickOnYourSelectedProduct("MacBook");

        //2.5 Verify the text “MacBook”
        Assert.assertEquals(detailPage.getPageTitle(), "MacBook",
                "Product not display");
        Thread.sleep(200);

        //2.6 Click on ‘Add To Cart’ button
        detailPage.clickOnAddToCartButton();
        Thread.sleep(200);

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(detailPage.getProductAddToCartSuccessMessage()
                        .contains("Success: You have added MacBook to your shopping cart!"),
                "Product not added to cart");
        Thread.sleep(5000);

        //2.8 Click on link “shopping cart” display into success message
        detailPage.clickOnShoppingCartLink();
        Thread.sleep(5000);

        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(cartPage.getShoppingCartPageTitle().contains("Shopping Cart"));

        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(cartPage.getProductName(), "MacBook",
                "Product name not matched");

        //2.11 Change Quantity "2"
        cartPage.changeQuantity("2");

        //2.12 Click on “Update” Tab
        cartPage.clickOnUpdateButton();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(cartPage.getProductUpdateSuccessMessage().contains("Success: You have modified your shopping cart!"),
                "Cart not modified");

        //2.14 Verify the Total £737.45
        Assert.assertEquals(cartPage.getProductTotalPrise(), "£737.45",
                "Total not matched");

        //  2.15 Click on the “Checkout” button
        notebooksPage.clickOnCheckOutButton();

        //  2.16 Verify the text “Checkout”
        notebooksPage.verifyCheckOutText();

        //  2.17 Verify the Text “New Customer”
        notebooksPage.verifyTextNewCustomers();

        //  2.18 Click on the “Guest Checkout” radio button
        notebooksPage.clickOnGuestCheckoutRadioButton();

        //  2.19 Click on “Continue” tab
        notebooksPage.clickOnContinueTab();

        // 2.20 Fill the mandatory fields
        notebooksPage.fillTheFieldName("Shaveta");
        notebooksPage.fillTheFieldLastName("sethi");
        notebooksPage.fillTheFieldEmail("ss@gmail.com");
        notebooksPage.fillTheFieldTelePhone("576598968");
        notebooksPage.fillTheFieldAddress("1,Lytham Close");
        notebooksPage.fillTheCity("Reading");
        notebooksPage.fillThePostCode("400101");

        //  2.21 Click on “Continue” Button
        notebooksPage.clickOnContinueButton2();

        // 2.22 Add Comments About your order into the text area
        notebooksPage.addComments();

        // 2.23 Check the Terms & Conditions check box
        notebooksPage.CheckTheTermsConditionsOfCheckBox();

        //  2.24 Click on the “Continue” button
        notebooksPage.ClickOnContinueButton();

    }

}


