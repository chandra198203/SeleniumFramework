package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.homePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups="Sanity")
	public void Registration() {
		try {
			logger.info("******** Starting the Registration Test***************");
			homePage hp = new homePage(driver);

			logger.info("Clicking on the MyAccount link");
			hp.clickonMyAccount();

			logger.info("Clicking on the Register link");
			hp.clickOnRegister();

			logger.info("Enter the data in Regisier page");
			AccountRegistrationPage RegPage = new AccountRegistrationPage(driver);

			RegPage.enterFirstName(RandomeString());
			RegPage.enterLastName(RandomeString());
			
			String email= (RandomeString() + "@gmail.com");
			RegPage.enterEmailId(email );
			System.out.println(email);
			
			RegPage.enterTelePhone(RandomeNumbers());

						
			String password = RandomeAlphaNumeric();
			RegPage.enterPassword(password);
			RegPage.enterConfirmPassword(password);
			System.out.println(password);

			RegPage.selectAgreementOption();
			RegPage.selectNewsLetterCheckboxOption();
			RegPage.clickSubmit();

			logger.info("Validating the success message for Registration");
			String ConfMsg = RegPage.verifyRegistrationconfirmation();
			if (ConfMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
				logger.info("Regestration Succesful");
			} else {
				
				logger.error("Registration process is failed...");
				logger.debug("Debug logs");
				Assert.assertTrue(false);

			}

		} catch (Exception e) {

			Assert.fail();
		}

		logger.info("****Regristration test is completed......");

	}

}
