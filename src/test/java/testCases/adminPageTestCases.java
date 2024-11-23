package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseClass;
import pageObjects.adminPage;
import pageObjects.dashboardPage;

@Test
public class adminPageTestCases extends baseClass {

	public adminPageTestCases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		loginPageTestCases loginPageTests = new loginPageTestCases();
		loginPageTests.cogmentoLogin();
	}

	@Test
	public void verifyAdminCreated() throws IOException, InterruptedException {
		dashboardPage dashboard = new dashboardPage();
		dashboard.navigateToAdminPage();
		adminPage admin = new adminPage();
		admin.createAdmin();
		admin.verifyAdminCreatedWithSuccess();
	}

	@Test
	public void sampleTest() {
		System.out.println("This is sample from adminpage");
	}

	@Test
	public void sampleTest2() {
		System.out.println("This is sample from adminpage for failed test case");
		int i = 10 / 0;
		System.out.println(i);
	}

	@Test
	public void sampleTest3() {
		System.out.println("This is sample from adminpage for failed test case");
		int i = 10 / 0;
		System.out.println(i);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
