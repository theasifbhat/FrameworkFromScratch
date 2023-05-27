import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.ProjectCatalogue;

import java.time.Duration;
import java.util.List;

public class StandaloneTest {
 public static void main(String[] args) {


  WebDriverManager.chromedriver().setup();
  WebDriver mDriver = new ChromeDriver();
  mDriver.manage().window().maximize();
  mDriver.get("https://rahulshettyacademy.com/client/");
  WebDriverWait wait = new WebDriverWait(mDriver,Duration.ofSeconds(6));

  By cartButton = By.xpath("//button[@routerlink='/dashboard/cart']");
  By cartPageItemName = By.cssSelector(".cartSection h3");
  String itemName = "ZARA COAT 3";

  LandingPage landingPage= new LandingPage(mDriver);
  landingPage.setUsernameFieldText("rahulrider@shetty.com");
  landingPage.setPasswordFieldText("Test@123");
  landingPage.clickOnLogin();

  ProjectCatalogue projectCatalogue = new ProjectCatalogue(mDriver);
  projectCatalogue.addProductToCart(itemName);



  //check if the item is present in the cart
  mDriver.findElement(cartButton).click();
  wait.until(ExpectedConditions.elementToBeClickable(cartPageItemName));
  boolean isFound = mDriver.findElements(cartPageItemName).stream().anyMatch(it->it.getText().contains(itemName));
  Assert.assertTrue(isFound);

  //click on checkout and enter the details
  WebElement checkoutButton = mDriver.findElement(By.cssSelector(".subtotal button"));
  checkoutButton.click();

  //enter country as india and click on

  By countryBox = By.cssSelector("input[placeholder='Select Country']");
  By indiaDropdownSelector = By.cssSelector("section.ng-star-inserted button:last-of-type");
  wait.until(ExpectedConditions.elementToBeClickable(countryBox));
  mDriver.findElement(countryBox).sendKeys("India");
  wait.until(ExpectedConditions.visibilityOfElementLocated(indiaDropdownSelector));
  mDriver.findElement(indiaDropdownSelector).click();
  WebElement checktButton = mDriver.findElement(By.cssSelector(".actions a"));
  checktButton.click();


  //get the thank you string

  By thankYouString = By.cssSelector(".hero-primary");
  wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouString));
  Assert.assertEquals( mDriver.findElement(thankYouString).getText(),"THANKYOU FOR THE ORDER.");
  System.out.println("Order ID is : "+ mDriver.findElement(By.cssSelector("tr[class='ng-star-inserted'] label:last-of-type")).getText().replace("|","").trim());
  mDriver.quit();








 }
}
