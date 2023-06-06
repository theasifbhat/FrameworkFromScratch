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

    @FindBy(xpath = "//input[@id='firstName']/following-sibling::div/div")
    WebElement firstNameErrorMessage;

    @FindBy(xpath = "//input[@id='userEmail']/following-sibling::div/div")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//input[@id='userMobile']/following-sibling::div/div")
    WebElement mobileErrorMessage;

    @FindBy(xpath = "//input[@id='userPassword']/following-sibling::div/div")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//input[@id='confirmPassword']/following-sibling::div/div")
    WebElement confirmPasswordErrorMessage;

    @FindBy(xpath = "//input[@type='checkbox']/parent::div/following-sibling::div[2]/div")
    WebElement termsAndConditionsErrorMessage;





    public RegisterPage(WebDriver mDriver) {
        super(mDriver);
        this.mDriver= mDriver;
        PageFactory.initElements(mDriver,this);
    }


    public void setFirstNameFieldText(String firstName){
        waitTillElementVisibleUsingWebElement(firstNameField);
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public String getFirstNameErrorMessage(){
        waitTillElementVisibleUsingWebElement(firstNameErrorMessage);
        return firstNameErrorMessage.getText();
    }

    public void setLastNameFieldText(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setUserEmailFieldText(String userEmail){
        userEmailField.clear();
        userEmailField.sendKeys(userEmail);
    }

    public String getEmailErrorMessage(){
        return emailErrorMessage.getText();
    }
    public void setUserMobileFieldText(String userMobile){
        userMobileField.clear();
        userMobileField.sendKeys(userMobile);
    }

    public String getMobileErrorMessage(){
        return mobileErrorMessage.getText();
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

    public String getPasswordFieldError(){
        return passwordErrorMessage.getText();
    }

    public void setConfirmPasswordFieldText(String confirmPassword){
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public String getConfirmPasswordErrorMessage(){
        return confirmPasswordErrorMessage.getText();
    }

    public void setTermsAndConditionsCheckbox(){
        termsAndConditionsCheckbox.click();
    }

    public String getTermsAndConditionsErrorMessage(){return termsAndConditionsErrorMessage.getText();}

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    

}
