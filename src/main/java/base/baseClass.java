package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ExcelUtility;

public class baseClass {
	public static Properties prop;
	public static WebDriver driver;

	public baseClass() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Lenovo\\eclipse-workspace\\Project\\src\\main\\java\\config\\config.properties");
		prop.load(fis);
	}

	public void launchUrl() {
		String browserName = prop.getProperty("browser");
		String chromeDriverPath = prop.getProperty("chromeDriverPath");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else {
			System.out.println("Do Nothing");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	public static String captureScreenshots(String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		// TakeScreenshot is an interface which is used to take the screenshots in test automation
		File source = ts.getScreenshotAs(OutputType.FILE);
		//getScreenshotAs is a method used in selenium to take the screenshots and which is coming from TakeScreenshot interface
		// OutputType.FILE --> create a temp file and we are storing it into the source
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String dest = System.getProperty("user.dir") + "\\ExtentReport\\Screenshots\\" + screenShotName + timestamp + ".png";
		//We have to store the screenshots in permanent location
		File destination = new File(dest);
		// We are passing the files here
		FileUtils.copyFile(source, destination);
		//FileUtils is a class which is used to perform some operations on files 
		//We are copying the file from temporary location to permanent location.
		return dest;
	}
    
	public static void readExcel() {
		String filePath = (System.getProperty("user.dir") + "/src/main/java/testData/TestData.xlsx");
		ExcelUtility.readExcelFile(filePath);
	}
    
}
