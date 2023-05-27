package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class ConformationPage extends AbstractComponent {

    WebDriver mDriver;


    By thankYouString = By.cssSelector(".hero-primary");

    @FindBy(css = ".hero-primary")
    WebElement thankYouStringWebElement;

    @FindBy(css = "tr[class='ng-star-inserted'] label:last-of-type")
    WebElement orderNumber;


    public ConformationPage(WebDriver mDriver) {
        super(mDriver);
        this.mDriver= mDriver;
        PageFactory.initElements(mDriver,this);
    }


    public String getOrderMessage(){
        return thankYouStringWebElement.getText();
    }

    public String getOrderNumber(){
        waitTillElementVisible(thankYouString);
        return orderNumber.getText().replace("|","").trim();
    }

}
