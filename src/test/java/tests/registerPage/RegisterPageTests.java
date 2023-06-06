package tests.registerPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import testingComponents.BaseTest;

public class RegisterPageTests extends BaseTest {

    RegisterPage registerPage;

    @BeforeMethod
    public void getRegisterPage(){
        registerPage= landingPage.clickOnRegisterationButton();
    }

    @Test
    public void testForCratingAnAccountWithFullDetails() {
        registerPage.setFirstNameFieldText("John");
        registerPage.setLastNameFieldText("Doe");
        registerPage.setUserEmailFieldText("admin@jk.com");
        registerPage.setUserMobileFieldText("1234567890");
        registerPage.setOccupationDropDown("Student");
        registerPage.setMaleRadioButton();
        registerPage.setPasswordFieldText("123456");
        registerPage.setConfirmPasswordFieldText("123456");
        registerPage.setTermsAndConditionsCheckbox();
        registerPage.clickOnRegisterButton();
        // need to work fro, here
    }


    @Test
    public void getAllErrorMessages(){
        registerPage.clickOnRegisterButton();
        Assert.assertEquals("*First Name is required",registerPage.getFirstNameErrorMessage());
        Assert.assertEquals("*Email is required",registerPage.getEmailErrorMessage());
        Assert.assertEquals("*Phone Number is required",registerPage.getMobileErrorMessage());
        Assert.assertEquals("*Password is required",registerPage.getPasswordFieldError());
        Assert.assertEquals("Confirm Password is required",registerPage.getConfirmPasswordErrorMessage());
        Assert.assertEquals("*Please check above checkbox",registerPage.getTermsAndConditionsErrorMessage());
    }
}
