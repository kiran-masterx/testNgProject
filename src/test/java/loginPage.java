import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.baseClass;
//@Listeners(utils.ExtentReportListener.class)
/*
 * @Listeners(utils.ExtentReportListener.class)
 * The above line of code can be used if we don't want to  
 * run the test from the xml file and still want the report for this particular class. 
 * 
 *  The above approach is not preferred over the xml file listener class. 
 *  Because we need to write the same code in all the test classes. 
 *  Also we should have the same report for all the test cases. 
 */

public class loginPage extends baseClass {

	public loginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void cogmentoLogin() throws IOException{
		baseClass base = new baseClass();
		base.launchUrl();
	}

}
