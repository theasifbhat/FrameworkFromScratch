package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponent;

import java.util.List;

public class ProjectCatalogue extends AbstractComponent {

    @FindBy(css = ".card")
    List<WebElement> products;

    @FindBy(css = "div[class*='ng-animating']")
    WebElement spinner;

    By productsLocator = By.cssSelector(".card");
    By addToCartLocator = By.cssSelector(".card-body button:last-of-type");

    By addedToCartToastLocator = By.id("toast-container");

    WebDriver mDriver;

    public ProjectCatalogue(WebDriver mDriver) {
        super(mDriver);
        this.mDriver = mDriver;
        PageFactory.initElements(mDriver, this);
    }


    public List<WebElement> getAllProducts() {
        waitTillElementVisible(addToCartLocator);
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


}
