package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Page.ValidateAddCategory;
import util.BrowserFactory;

public class AddCategoryTest {
	WebDriver driver;
	 String name = "Techfios";

    @Test
    public void validateAddCategoryTest() {
        driver = BrowserFactory.init();
        ValidateAddCategory validateAddCategory = PageFactory.initElements(driver, ValidateAddCategory.class);
		validateAddCategory.addCategory(name + Math.random());
        BrowserFactory.tearDown();
    }
    
    @Test
    public void validateDuplicateDataTest() {
    	 driver = BrowserFactory.init();
         ValidateAddCategory validateAddCategory = PageFactory.initElements(driver, ValidateAddCategory.class);
 		 validateAddCategory.checkDuplicationData(name);
         BrowserFactory.tearDown();
    }
    @Test
    public void validateDropDownTest() {
    	driver = BrowserFactory.init();
        ValidateAddCategory validateAddCategory = PageFactory.initElements(driver, ValidateAddCategory.class);
		validateAddCategory.validateDropDownMonth();
         BrowserFactory.tearDown();
    }
}
