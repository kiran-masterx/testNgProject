package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseClass;
import pageObjects.dashboardPage;
import pageObjects.leavePage;

public class leavePageTestCases extends baseClass {
	public leavePageTestCases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		loginPageTestCases loginPageTests = new loginPageTestCases();
		loginPageTests.cogmentoLogin();
	}
	
	@Test	
	public void verifyLeaveCreated() throws IOException, InterruptedException {
        dashboardPage dashboard = new dashboardPage();
        dashboard.navigateToLeavePage();
        leavePage leave = new leavePage();
        leave.createLeave();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
