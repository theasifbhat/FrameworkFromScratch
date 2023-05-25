import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class StandaloneTest {
 public static void main(String[] args) throws InterruptedException {


  WebDriverManager.chromedriver().setup();
  WebDriver mDriver = new ChromeDriver();
  mDriver.manage().window().maximize();
  mDriver.get("https://rahulshettyacademy.com/client/");
  WebElement usernameField= mDriver.findElement(By.id("userEmail"));
  WebElement passwordField= mDriver.findElement(By.id("userPassword"));
  WebElement loginButton= mDriver.findElement(By.id("login"));
  By cartButton = By.xpath("//button[@routerlink='/dashboard/cart']");
  By cartPageItemName = By.cssSelector(".cartSection h3");
  String itemName;


  usernameField.sendKeys("rahulrider@shetty.com");
  passwordField.sendKeys("Test@123");
  loginButton.click();


  WebDriverWait wait = new WebDriverWait(mDriver, Duration.ofSeconds(8));
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".container")));

//gets all products on homepage
  List<WebElement> products = mDriver.findElements(By.cssSelector(".card"));

  //stores a product with name zara among all products
  WebElement selectedProduct  = products.stream()
          .filter(it-> it.findElement(By.cssSelector("b"))
          .getText()
          .toLowerCase()
          .contains("zara coat"))
          .findFirst()
          .orElse(null);

  itemName= selectedProduct.getText().split("\\$")[0].trim();
  selectedProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();

//click on cart button when the item is added to cart
  wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container")));
  wait.until(ExpectedConditions.invisibilityOf(mDriver.findElement(By.cssSelector("div[class*='ng-animating']"))));
  mDriver.findElement(cartButton).click();

  //check if the item is present in the cart
  wait.until(ExpectedConditions.elementToBeClickable(cartPageItemName));
  boolean isFound = mDriver.findElements(cartPageItemName).stream().anyMatch(it->it.getText().equals(itemName));
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
