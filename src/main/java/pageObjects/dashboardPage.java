package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;

public class dashboardPage extends baseClass {
	
	public dashboardPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[text()='Admin']")
	WebElement adminPage;
	
	@FindBy (xpath = "//span[text()='Leave']")
	WebElement leavePage;
	 
	public void navigateToAdminPage() {
		adminPage.click();
	}
	
	public void navigateToLeavePage() {
		leavePage.click();
	}
	
	

}
