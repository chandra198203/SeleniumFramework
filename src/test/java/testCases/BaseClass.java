package testCases;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.restassured.internal.support.FileReader;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;

	
	@BeforeClass (groups = {"Sanity","Main"})
	@Parameters({ "browser" })
	public void LauchWebPage(String browser) throws IOException  {
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser...");
			return;

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
	}

	@AfterClass (groups = {"Sanity","Main"})
	public void TearDown() {
		driver.quit();
	}

	String RandomeString() {
		String GeneratedString = RandomStringUtils.randomAlphabetic(5);
		return GeneratedString;
	}

	String RandomeNumbers() {
		String GeneratedNumbers = RandomStringUtils.randomNumeric(8);
		return GeneratedNumbers;
	}

	String RandomeAlphaNumeric() {
		String GeneratedAlphaNumeric = RandomStringUtils.randomAlphanumeric(5);
		String GeneratedNumbers = RandomStringUtils.randomNumeric(3);

		return (GeneratedAlphaNumeric + "@" + GeneratedNumbers);
	}
}
