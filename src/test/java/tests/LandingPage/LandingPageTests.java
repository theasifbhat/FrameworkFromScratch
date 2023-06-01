package tests.LandingPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import testingComponents.BaseTest;

public class LandingPageTests extends BaseTest {
@Test
public void testForCheckingLoginWithEmptyUsername(){
    landingPage.setPasswordFieldText("helloWorld");
    landingPage.clickOnLogin();
    Assert.assertEquals(landingPage.getErrorMessageFromEmptyUserField(),"*Email is not required");
}



}
