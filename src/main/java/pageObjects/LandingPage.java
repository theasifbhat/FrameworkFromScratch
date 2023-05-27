package pageObjects;

import org.openqa.selenium.By;
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

public void clickOnLogin(){
    loginButton.click();
}



}
