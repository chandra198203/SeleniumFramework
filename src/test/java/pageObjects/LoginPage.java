package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtLoginPassword;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtLoginEmail;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	
	public void EnterLoginEmail(String Emailid) {
		txtLoginEmail.sendKeys(Emailid);
	}

	public void EnterLoginPassword(String Password) {
		txtLoginPassword.sendKeys(Password);
	}

	public void ClkLogin() {
		btnLogin.click();
	}

}
