package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.baseClass;

public class adminPage extends baseClass {
	
	public adminPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[text()=\" Add \"]")
	WebElement addButton;
	
	@FindBy(xpath="//*[text()=\"User Role\"]/parent::div/following-sibling::div")
	WebElement userRoleSelectBox;
	
	@FindBy(xpath="//*[text()='User Role']/parent::div/following-sibling::div//div[@role='option'][2]")
	WebElement userRoleOptionSelection;
	
	@FindBy(xpath = "//label[text()='Employee Name']/parent::div/following-sibling::div//div//div//input")
	WebElement employeeNameInput;
	
	@FindBy(xpath = "//label[text()='Employee Name']/parent::div/following-sibling::div//div/child::div[2]//div[1]")
	WebElement selectEmployeeName;
	
	@FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div")
	WebElement statusSelectBox;
	
	@FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div//div[@role='option'][3]")
	WebElement statusSelection;
	
	@FindBy(xpath = "//label[text() = 'Username']/parent::div/following-sibling::div//input")
	WebElement usernameInput;
	
	@FindBy(xpath = "//label[text() = 'Password']/parent::div/following-sibling::div//input")
	WebElement passwordInput;
	
	@FindBy(xpath = "//label[text() = 'Confirm Password']/parent::div/following-sibling::div//input")
	WebElement confirmPasswordInput;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@id='oxd-toaster_1']//p[text()='Success']")
	WebElement successTile;
	
	public void createAdmin() throws InterruptedException {
		addButton.click();
		userRoleSelectBox.click();
		userRoleOptionSelection.click();
		employeeNameInput.sendKeys("Test");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getElementText())));
//		element.click();
		Thread.sleep(3000);
		
		/** Here the drop down is going away when trying to right click or inspect.
		 *  So paused the page execution for sometime in console. 
		 *  Below code is used in console of Chrome Browser.
		 *  setTimeout(()=>{debugger;},5000)
		 *  Here the script wait for 5 seconds and then pause.
		 *  So the drop downs and floating element don't fed away. 
		**/
		
		selectEmployeeName.click();
		statusSelectBox.click();
		statusSelection.click();
		usernameInput.sendKeys("testUser" + generateRandomNumber());
		passwordInput.sendKeys("Test@1234");
		confirmPasswordInput.sendKeys("Test@1234");
		submitButton.click();
	}
	
	public void verifyAdminCreatedWithSuccess() {
		successTile.isDisplayed();
	}
	
	public int generateRandomNumber() {
        Random rand = new Random();
        int randomTwoDigitNumber = rand.nextInt(90) + 10; // generates 10-99
		return randomTwoDigitNumber;
	}

}
