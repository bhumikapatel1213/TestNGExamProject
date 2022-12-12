package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertyLoader {
private Properties prop;
    
    public PropertyLoader() {
	  try{
          InputStream input = new FileInputStream(System.getProperty("user.dir") + "\\config\\data.properties");
          prop = new Properties();
          prop.load(input);
      }catch(Exception ex) {
          prop = null;
      }
    } 
  public List<String> getMonthsList() {
      String months = prop.getProperty("data.months");
      return Arrays.asList(months.split(","));
  }
}
