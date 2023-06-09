package tests.productCatalogue;

import dataproviders.DataProviders;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductCatalogue;
import testingComponents.BaseTest;

import java.util.List;

public class ProductCatalogueTests extends BaseTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "getSingleCredentials")
    public void testSearchProduct(String username, String password, String itemName, String country){

    ProductCatalogue productCatalogue=  landingPage.loginWithCredentials(username,password);
    System.out.println("item name is: "+itemName);
    productCatalogue.searchForProduct(itemName);
    List<WebElement> allItems= productCatalogue.getAllProducts();
    System.out.println("Number of items found: "+allItems.size());

    allItems.forEach(item->{
        String sanitizedItemName= item.getText().split("\\$")[0].trim();
        System.out.println("item san:"+sanitizedItemName);
        if (!sanitizedItemName.contains(itemName)){
            Assert.fail("Item not found: "+sanitizedItemName);
        }
    });
}


    @Test ( dataProviderClass = DataProviders.class, dataProvider = "getSingleCredentials")
    public void testMinMaxPriceFilter(String username, String password, String itemName, String country) throws InterruptedException {
        String minPrice="231500";
        String maxPrice="231500";

        ProductCatalogue productCatalogue=  landingPage.loginWithCredentials(username,password);
      productCatalogue.setMinMaxPrice(minPrice,maxPrice);

      List<WebElement> items = productCatalogue.getAllProducts();
      Thread.sleep(1000);  /// causes stale element exception if not used
      items.forEach(item->{
          String price = item.findElement(productCatalogue.priceLocator).getText().split("\\$")[1].trim().split("View")[0].trim();
          if (!(Integer.parseInt(price)>= Integer.parseInt(minPrice) && Integer.parseInt(price)<=Integer.parseInt(maxPrice))){
              Assert.fail("Price is not in range: "+price);
          }
      });

    }


}