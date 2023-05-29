package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import pageObjects.MyOrdersPage;

import java.time.Duration;

public class AbstractComponent {

    WebDriver mDriver;
    WebDriverWait webDriverWait;

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartButton;

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement myCartButton;


    public AbstractComponent(WebDriver mDriver) {
        this.mDriver = mDriver;
        webDriverWait = new WebDriverWait(mDriver, Duration.ofSeconds(6));
        PageFactory.initElements(mDriver,this);
    }

    public void waitTillElementVisible(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitTillElementInvisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitTillElementVisibleUsingWebElement(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public CartPage clickOnCartButton(){
        cartButton.click();
        return new CartPage(mDriver);
    }

    public MyOrdersPage clickOnMyOrdersButton(){
        waitTillElementVisibleUsingWebElement(myCartButton);
        myCartButton.click();
        return new MyOrdersPage(mDriver);
    }


}
