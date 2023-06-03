package tests.LandingPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import testingComponents.BaseTest;
import testingComponents.RetryMechanism;

public class LandingPageTests extends BaseTest {
@Test(retryAnalyzer = RetryMechanism.class)         //we have to give retryAnalyzer for every test that we want to re-run that has failed for the first time
public void testForCheckingLoginWithEmptyUsername(){
    landingPage.setPasswordFieldText("helloWorld");
    landingPage.clickOnLogin();
    Assert.assertEquals(landingPage.getErrorMessageFromEmptyUserField(),"*Email is required");
}



}
