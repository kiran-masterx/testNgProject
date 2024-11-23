package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.baseClass;
import utils.ExcelDataReader;
import utils.ExcelUtility;

public class ReadExcel extends baseClass {
	public ReadExcel() throws IOException {
		super();
	}

	// Reading data by giving the position in excel.
	@Test(priority = 0)
	public void testExample() {
		baseClass.readExcel();
		String username = ExcelUtility.getData(1, 1);
		System.out.println(username);
	}

	@Test(priority = 1)
	public void getDataWithKey() {
		baseClass.readExcel();
		String key = "username";
		String value = ExcelUtility.getData(key);
		System.out.println("Value for key '" + key + "': " + value);
		// Printing all the values of any specific keys
		ExcelUtility.printValuesForKey(key);
	}

	@Test(dataProvider="TestData2", dataProviderClass = ExcelDataReader.class)
	public void executeTestForAllTestData(String username, String password) {
		// Your test logic goes here
		System.out.println("Login test executed for username: " + username + " and password: " + password);
	}

}
