package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;

public class homePage extends BasePage {

	WebDriver driver;

	public homePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement lnkmyAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkregister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnklogin;

	public void clickonMyAccount() {
		lnkmyAccount.click();
	}

	public void clickOnRegister() {
		lnkregister.click();
	}
	
	public void ClickOnLogin() {
		lnklogin.click();
	}

}
