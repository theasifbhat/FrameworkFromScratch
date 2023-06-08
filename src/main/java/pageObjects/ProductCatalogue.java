package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {

    @FindBy(css = ".card")
    List<WebElement> products;

    @FindBy(css = "div[class*='ng-animating']")
    WebElement spinner;

    @FindBy(css = "section form div input")
    WebElement searchField;

    By productsLocator = By.cssSelector(".mb-3");
    By addToCartLocator = By.cssSelector(".card-body button:last-of-type");
    By addedToCartToastLocator = By.id("toast-container");
    By searchFieldLocator = By.cssSelector("section>form>div>input");
  //  By searchFieldLocator = By.xpath("//html/body/app-root/app-dashboard/section[1]/form/div[1]/Input");
    //doesnt work with xpath or css
    WebDriver mDriver;

    public ProductCatalogue(WebDriver mDriver) {
        super(mDriver);
        this.mDriver = mDriver;
        PageFactory.initElements(mDriver, this);
    }


    public List<WebElement> getAllProducts() {
        waitTillElementVisible(productsLocator);
        return products;
    }

    public WebElement getProductWebElementWithName(String productName) {
        return getAllProducts().stream().filter(it -> it.getText().contains(productName)).findFirst().orElse(null);
    }

    public void addProductToCart(String productName) {
        getProductWebElementWithName(productName).findElement(addToCartLocator).click();
        waitTillElementVisible(addedToCartToastLocator);
        waitTillElementInvisible(spinner);

    }

    public void searchForProduct(String productName) {
        waitTillElementIsPresent(searchFieldLocator);
        Actions action = new Actions(mDriver);
        action.sendKeys(searchField,productName.toLowerCase()+Keys.ENTER).build().perform();
        waitTillElementVisible(productsLocator);
    }


}
