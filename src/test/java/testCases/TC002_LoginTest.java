package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.homePage;

public class TC002_LoginTest extends BaseClass {

	//@Listeners(ExtentReportManager.class)
	@Test (groups = {"Sanity","Main"})
	public void LoginMethod() {

		try {

			logger.info("*************Login Test***************");
			homePage homepage = new homePage(driver);
			homepage.clickonMyAccount();
			homepage.ClickOnLogin();

			LoginPage loginpage = new LoginPage(driver);

			System.out.println(p.getProperty("Email"));
			System.out.println(p.getProperty("Password"));

			logger.info("Enter the Credentials");
			loginpage.EnterLoginEmail(p.getProperty("Email"));
			loginpage.EnterLoginPassword(p.getProperty("Password"));
			
			logger.info("click on Login");
			loginpage.ClkLogin();

			logger.info("Verify the Login status");
			MyAccountPage AccountPage = new MyAccountPage(driver);
			boolean LoginStatus = AccountPage.verifySuccessfulLogin();

			if (LoginStatus) {

				Assert.assertTrue(true);
				logger.info("*************Login Test Successful***************");
			}
			else 
			{
				logger.info("*************Login Test Failed***************");
				Assert.fail();
			}
			
		}

		catch (Exception e)

		{
			System.out.println(e.getMessage());
		
		}

	}

}
