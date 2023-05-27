package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

    WebDriver mDriver;



    By countryBox = By.cssSelector("input[placeholder='Select Country']");
    By indiaDropdownSelector = By.cssSelector("section.ng-star-inserted button:last-of-type");


    @FindBy(css = "input[placeholder='Select Country']")
    WebElement countryInputField;

    @FindBy(css = ".actions a")
    WebElement checkoutButton;

    @FindBy(css = "section.ng-star-inserted button:last-of-type")
    WebElement countrySelectorFromDropdown;

    public CheckoutPage(WebDriver mDriver) {
        super(mDriver);
        this.mDriver= mDriver;
        PageFactory.initElements(mDriver,this);
    }


    public void setCountry(String country){
        waitTillElementVisible(countryBox);
        countryInputField.clear();
        countryInputField.sendKeys(country);
        waitTillElementVisible(indiaDropdownSelector);
        countrySelectorFromDropdown.click();

    }


    public ConformationPage clickOnCheckOutButton(){
        checkoutButton.click();
        return new ConformationPage(mDriver);
    }



}
