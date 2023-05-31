package tests.CheckoutPage;

import dataproviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testingComponents.BaseTest;

import java.util.HashMap;


public class CheckoutPageTests extends BaseTest {

 @Test (dataProvider = "getDataWithJson", dataProviderClass = DataProviders.class)
  public void testOrderWorkingTest(HashMap<String,String> map) {

  landingPage.setUsernameFieldText(map.get("username"));
  landingPage.setPasswordFieldText(map.get("password"));

  ProjectCatalogue projectCatalogue = landingPage.clickOnLogin();
  projectCatalogue.addProductToCart(map.get("itemName"));

  CartPage cartPage=projectCatalogue.clickOnCartButton();
  Assert.assertTrue(cartPage.checkIfItemInCartContains(map.get("itemName")));

  pageObjects.CheckoutPage checkoutPage=  cartPage.clickOnCheckoutButton();
  checkoutPage.setCountry(map.get("country"));
  ConformationPage conformationPage=  checkoutPage.clickOnCheckOutButton();

  System.out.println("Order number is: "+conformationPage.getOrderNumber());
  Assert.assertEquals(conformationPage.getOrderMessage(), "THANKYOU FOR THE ORDER.");

 }




}
