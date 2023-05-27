package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver mDriver;

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartItemName;

    @FindBy(css = ".subtotal button")
    WebElement checkoutButton;

    By cartItemNameLocator = By.cssSelector(".cartSection h3");

    public CartPage(WebDriver mDriver) {
        super(mDriver);
        this.mDriver = mDriver;
        PageFactory.initElements(mDriver, this);
    }

    public List<WebElement> getallCartItems() {
        waitTillElementVisible(cartItemNameLocator);
        return cartItemName;
    }

    public boolean checkIfItemInCartContains(String productName) {
        return getallCartItems().stream().anyMatch(it -> it.getText().contains(productName));

    }

    public CheckoutPage clickOnCheckoutButton(){
        checkoutButton.click();
        return new CheckoutPage(mDriver);
    }


}
