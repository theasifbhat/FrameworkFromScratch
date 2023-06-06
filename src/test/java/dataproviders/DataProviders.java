package dataproviders;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.List;

import static helpers.JsonHandler.convertListTo2DArray;
import static helpers.JsonHandler.getJsonDataToMap;

public class DataProviders {
    //data providers can be used in two ways
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"rahulrider@shetty.com", "Test@123", "ZARA COAT 3", "India"}};
    }

    //using hashmap
    @DataProvider
    public Object[][] getDataWithHashmap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "rahulrider@shetty.com");
        map.put("password", "Test@123");
        map.put("itemName", "ZARA COAT 3");
        map.put("country", "India");
        return new Object[][]{{map}};
    }

    //using an external json object

    @DataProvider
    public Object[][] getDataWithJson() {
        List<HashMap<String, String>> data = getJsonDataToMap("//src//test//java//JSONObjects//data.json");
        return convertListTo2DArray(data);
    }


}
