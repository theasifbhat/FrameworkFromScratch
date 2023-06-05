package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AbstractComponent {

    WebDriver mDriver;


    @FindBy(id="firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id="userEmail")
    WebElement userEmailField;

    @FindBy(id="userMobile")
    WebElement userMobileField;

    @FindBy (css = ".custom-select")
    WebElement occupationDropDown;

    @FindBy(css = "input[value='Male']")
    WebElement maleRadioButton;

    @FindBy(css = "input[value='Female']")
    WebElement femaleRadioButton;

    @FindBy(id="userPassword")
    WebElement passwordField;

    @FindBy(id = "confirmPassword")
    WebElement confirmPasswordField;

    @FindBy(css = "input[type='checkbox']")
    WebElement termsAndConditionsCheckbox;

    @FindBy(id = "login")
    WebElement registerButton;


    public RegisterPage(WebDriver mDriver) {
        super(mDriver);
        this.mDriver= mDriver;
        PageFactory.initElements(mDriver,this);
    }


    public void setFirstNameFieldText(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameFieldText(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setUserEmailFieldText(String userEmail){
        userEmailField.clear();
        userEmailField.sendKeys(userEmail);
    }

    public void setUserMobileFieldText(String userMobile){
        userMobileField.clear();
        userMobileField.sendKeys(userMobile);
    }

    public void setOccupationDropDown(String occupation){
        selectFromDropDown(occupationDropDown,occupation);
    }

    public void setMaleRadioButton(){
        maleRadioButton.click();
    }

    public void setFemaleRadioButton(){
        femaleRadioButton.click();
    }

    public void setPasswordFieldText(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void setConfirmPasswordFieldText(String confirmPassword){
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void setTermsAndConditionsCheckbox(){
        termsAndConditionsCheckbox.click();
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    

}
