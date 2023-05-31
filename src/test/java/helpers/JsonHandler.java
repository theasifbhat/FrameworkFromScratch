package helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonHandler {

public static List<HashMap<String, String>> getJsonDataToMap(String path){

   ObjectMapper objectMapper = new ObjectMapper();
   String jsonFile="";
   List<HashMap<String, String>> data = new ArrayList<>();

   try {
      jsonFile = FileUtils.readFileToString(new File(System.getProperty("user.dir") + path),
              StandardCharsets.UTF_8);
      data = objectMapper.readValue(jsonFile, new TypeReference<List<HashMap<String, String>>>() {
      });
   }
   catch (Exception exception){
      System.out.println("Exception in getJsonToMap");
   }

   return data;
}


   public static Object[][] convertListTo2DArray(List<HashMap<String, String>> list) {
      Object[][] array = new Object[list.size()][];

      for (int i = 0; i < list.size(); i++) {
         HashMap<String, String> hashmap = list.get(i);
         array[i] = new Object[] { hashmap };
      }
      return array;
   }


}
