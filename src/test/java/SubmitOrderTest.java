
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testingComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

 @Test
 public void checkOrderWorkingTest() {

  String itemName = "ZARA COAT 3";
  LandingPage landingPage= launchApplication();
  landingPage.setUsernameFieldText("rahulrider@shetty.com");
  landingPage.setPasswordFieldText("Test@123");

  ProjectCatalogue projectCatalogue = landingPage.clickOnLogin();
  projectCatalogue.addProductToCart(itemName);

  CartPage cartPage=projectCatalogue.clickOnCartButton();
  Assert.assertTrue(cartPage.checkIfItemInCartContains(itemName));

  CheckoutPage checkoutPage=  cartPage.clickOnCheckoutButton();
  checkoutPage.setCountry("India");
  ConformationPage conformationPage=  checkoutPage.clickOnCheckOutButton();

  System.out.println("Order number is: "+conformationPage.getOrderNumber());
  Assert.assertEquals(conformationPage.getOrderMessage(), "THANKYOU FOR THE ORDER.");
  mDriver.close();

 }
}
