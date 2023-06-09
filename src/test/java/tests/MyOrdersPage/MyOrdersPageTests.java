package tests.MyOrdersPage;

import dataproviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MyOrdersPage;
import testingComponents.BaseTest;

import java.util.HashMap;

public class MyOrdersPageTests extends BaseTest {


    //this test depends upon the checkOrderWorkingTest() test from SubmitOrderTestClass
    //need to apply depends on annotation on this test method.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "getDataWithJson")
    public void checkIfOrderedItemIsPresentInMyOrders(HashMap<String, String> map) {
        landingPage.setUsernameFieldText(map.get("username"));
        landingPage.setPasswordFieldText(map.get("password"));
        MyOrdersPage myOrdersPage = landingPage.clickOnLogin().clickOnMyOrdersButton();
        Assert.assertTrue(myOrdersPage.doesWebElementWithItemNameExist(map.get("itemName")));
    }

}
