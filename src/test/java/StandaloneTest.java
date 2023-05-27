import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.*;

import java.security.ProtectionDomain;
import java.time.Duration;

public class StandaloneTest {
 public static void main(String[] args) {


  WebDriverManager.chromedriver().setup();
  WebDriver mDriver = new ChromeDriver();
  mDriver.manage().window().maximize();
  mDriver.get("https://rahulshettyacademy.com/client/");
  WebDriverWait wait = new WebDriverWait(mDriver,Duration.ofSeconds(6));

  String itemName = "ZARA COAT 3";

  LandingPage landingPage= new LandingPage(mDriver);
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
  mDriver.quit();

 }
}
