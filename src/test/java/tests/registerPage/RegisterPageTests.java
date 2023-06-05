package tests.registerPage;

import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import testingComponents.BaseTest;

public class RegisterPageTests extends BaseTest {


    @Test
    public void testForCratingAnAccountWithFullDetails() {
        RegisterPage registerPage = landingPage.clickOnRegisterationButton();
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
}
