package tests.MyOrdersPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MyOrdersPage;
import testingComponents.BaseTest;

public class MyOrdersPageTests extends BaseTest {



    //this test depends upon the checkOrderWorkingTest() test from SubmitOrderTestClass
    //need to apply depends on annotation on this test method.
 @Test
    public void checkIfOrderedItemIsPresentInMyOrders(){
    landingPage.setUsernameFieldText("rahulrider@shetty.com");
    landingPage.setPasswordFieldText("Test@123");
    MyOrdersPage myOrdersPage= landingPage.clickOnLogin().clickOnMyOrdersButton();
    Assert.assertTrue(myOrdersPage.doesWebElementWithItemNameExist("ZARA COAT 3"));
 }

}
