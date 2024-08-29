package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelePhone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement chkNewsLetter;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkAgree;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfiramtion;

	public void enterFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void enterEmailId(String emailid) {
		txtEmail.sendKeys(emailid);
	}

	public void enterTelePhone(String telephone) {
		txtTelePhone.sendKeys(telephone);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void enterConfirmPassword(String cnfpassword) {
		txtConfirmPassword.sendKeys(cnfpassword);
	}

	public void selectNewsLetterCheckboxOption() {
		chkNewsLetter.click();
	}

	public void selectAgreementOption() {
		chkAgree.click();
	}

	public void clickSubmit() {
		btnnContinue.click();
	}

	public String verifyRegistrationconfirmation() {
		try {
			return (msgConfiramtion.getText());
		} 
		catch (Exception e) {
			return (e.getMessage());
		}
	}

}