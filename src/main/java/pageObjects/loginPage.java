package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;

public class loginPage extends baseClass {

	public loginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Username : Admin']")
	WebElement getUsername;

	@FindBy(xpath = "//p[text()='Password : admin123']")
	WebElement getPassword;

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameInput;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//p[text()='CSRF token validation failed']")
	WebElement tokenValidationError;

	public void loginByCapturingCreds() {
		String un = getUsername.getText().split(" : ")[1];
		String pw = getPassword.getText().split(" : ")[1];
		usernameInput.sendKeys(un);
		passwordInput.sendKeys(pw);
		submitButton.click();
		if(tokenValidationError.isDisplayed()) {
			usernameInput.sendKeys(un);
			passwordInput.sendKeys(pw);
			submitButton.click();
		}
	}

}
