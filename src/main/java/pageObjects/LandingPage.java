package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver mDriver;

    @FindBy(id = "userEmail")
    WebElement usernameField;
    @FindBy(id = "userPassword")
    WebElement passwordField;
    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(css = "a[routerLink='/auth/register']")
    WebElement registerButton;

    @FindBy(css = ".invalid-feedback")
    WebElement errorMessageForEmptyField;

public LandingPage(WebDriver mDriver){
    this.mDriver= mDriver;
    PageFactory.initElements(mDriver,this);
}

public void setUsernameFieldText(String username) {
    usernameField.sendKeys(username);
}

public void setPasswordFieldText(String password){
    passwordField.sendKeys(password);
}



public String getErrorMessageFromEmptyUserField(){
    return errorMessageForEmptyField.getText();
}

public ProjectCatalogue clickOnLogin(){
    loginButton.click();
    return new ProjectCatalogue(mDriver);
}

public void goToLandingPage(){
    mDriver.get("https://rahulshettyacademy.com/client/");
}

public RegisterPage clickOnRegisterationButton(){
    registerButton.click();
    return new RegisterPage(mDriver);
    }



}
