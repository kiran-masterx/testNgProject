package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.baseClass;
import pageObjects.loginPage;

public class loginPageTestCases extends baseClass {

	public loginPageTestCases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void cogmentoLogin() throws IOException{
		baseClass base = new baseClass();
		base.launchUrl();
		loginPage login = new loginPage();
		login.loginByCapturingCreds();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
