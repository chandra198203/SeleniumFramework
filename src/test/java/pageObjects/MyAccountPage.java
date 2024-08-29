package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msggHeading;

	public boolean verifySuccessfulLogin() {
		try {
			return msggHeading.isDisplayed();
		} catch (Exception e) {
			return false;

		}

	}

}
