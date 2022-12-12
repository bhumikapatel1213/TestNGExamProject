package Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import util.PropertyLoader;

public class ValidateAddCategory {
	 WebDriver driver;

	    public  void validateAddCategoryCheck(WebDriver driver) {
	        this.driver = driver; 
	    }

	    @FindBy(how = How.CSS, using = "input[name*='categorydata']")
	    WebElement categoryDataField;
	    
	    @FindBy(how = How.CSS, using = "input[value*='Add category']")
	    WebElement addCategoryButton;
	    
	   // @FindBy(css = "select[name='due_month']") WebElement monthDropDownList;
	    
	    @FindBy(how = How.CSS, using = "select[name*='due_month']")
	    WebElement monthDropDownList;
	    
	    @FindBy(how = How.TAG_NAME, tagName = "body")
	    WebElement bodyData;
	    
	    public void addCategory(String name) {
	    	categoryDataField.sendKeys(name);
	    	addCategoryButton.click();
	    	
	    }
	    public void checkDuplicationData(String Name){
			addCategory(Name);
			Assert.assertTrue(bodyData.getText().contains("The category you want to add already exists: " + Name));
	    }
	    
	    public void validateDropDownMonth(){
	    	monthDropDownList.click();
	    	
	    	// get the select dropdown element
	    	Select sel = new Select(monthDropDownList);
			
	        // read all the options from select element
	        List<WebElement> options = sel.getOptions();

	        // add all months from dropdown to a list
	        List<String> monthsdropdown = new ArrayList();

	        for (int i = 0; i < options.size(); i++) {
	            monthsdropdown.add(options.get(i).getText());
	        }

	        // assert true if dropdown contains all months from MONTHS_LIST list
	        PropertyLoader prop = new PropertyLoader();
	        List<String> MONTHS_LIST = prop.getMonthsList();

	        Assert.assertTrue(monthsdropdown.containsAll(MONTHS_LIST), "Month check");
	    }
	    
}
