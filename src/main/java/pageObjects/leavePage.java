package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;

public class leavePage extends baseClass {

	public leavePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[text() ='From Date']/parent::div//following-sibling::div//input")
	WebElement fromDate;
	
	@FindBy(xpath="//div[contains(@class,'oxd-calendar-date --selected')]/parent::div//following::div[5]")
	WebElement selectFromDate;
	
	@FindBy(xpath="//label[text() ='To Date']/parent::div//following-sibling::div//input")
	WebElement toDate;
	
	@FindBy(xpath="//div[contains(@class,'oxd-calendar-date --selected')]/parent::div//following::div[9]")
	WebElement selectToDate;
	
	@FindBy(xpath="//label[text() ='Show Leave with Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text--active')]")
	WebElement showLeaveWithStatusDropdown;
	
	@FindBy(xpath="//label[text() ='Show Leave with Status']/parent::div/following::*[text()='Taken']")
	WebElement selectLeaveStatus;
	
	@FindBy(xpath="//label[text() ='Leave Type']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text--active')]")
	WebElement leaveTypeDropdown;
	
	@FindBy(xpath="//label[text() ='Leave Type']/parent::div/following::*[text()='CAN - Personal']")
	WebElement selectLeaveType;
	
	@FindBy(xpath="//label[text() ='Employee Name']/parent::div/following-sibling::div//input")
	WebElement employeeNameInput;
	
	@FindBy(xpath="//label[text()='Employee Name']/parent::div/following-sibling::div//div/child::div[2]//div[1]")
	WebElement selectEmployeeName;
	
	@FindBy(xpath="//label[text() ='Sub Unit']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text--active')]")
	WebElement subUnitDropdown;
	
	@FindBy(xpath="//label[text() ='Sub Unit']/parent::div/following::*[text()='Engineering']")
	WebElement selectSubUnit;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	public void createLeave() throws InterruptedException {
		fromDate.click();
		selectFromDate.click();
		toDate.click();
		selectToDate.click();
		showLeaveWithStatusDropdown.click();
		selectLeaveStatus.click();
		leaveTypeDropdown.click();
		selectLeaveType.click();
		employeeNameInput.sendKeys("Test");
		Thread.sleep(3000);
		selectEmployeeName.click();
		subUnitDropdown.click();
		selectSubUnit.click();
	}
	
	
}
