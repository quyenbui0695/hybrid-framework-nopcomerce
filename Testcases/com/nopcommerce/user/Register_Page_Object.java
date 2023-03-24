package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

public class Register_Page_Object extends BasePage {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress;
	private String firstName = "Mint";
	private String lastName = "Kan";
	private String password = "Abc@123";
	
	

	// Declare (khai bao)
	// BasePage basePage;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject (driver);

		emailAddress = "mint" + generateFakeNumber() + "@hotmail.com";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		

	}

	@Test
	public void TC_01_Register_Empty_Data() {

		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getTextOfFirstName(), "First name is required.");
		Assert.assertEquals(registerPage.getTextOfLastName(), "Last name is required.");
		Assert.assertEquals(registerPage.getTextOfEmail(), "Email is required.");
		Assert.assertEquals(registerPage.getTextOfPassword(), "Password is required.");
		Assert.assertEquals(registerPage.getTextOfConfirmPassword(), "Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {

		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();

		registerPage.senKeyToFirstNameField(firstName);
		registerPage.senKeyToLastNameField(lastName);
		registerPage.senKeyToEmailField("@#$$$");
		registerPage.senKeyToPasswordField(password);
		registerPage.senKeyToConfirmPasswordField(password);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getTextOfEmail(), "Wrong email");

	}

	@Test
	public void TC_03_Valid_Email() {

		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.senKeyToFirstNameField(firstName);
		registerPage.senKeyToLastNameField(lastName);
		registerPage.senKeyToEmailField(emailAddress);
		registerPage.senKeyToPasswordField(password);
		registerPage.senKeyToConfirmPasswordField(password);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getTextOfSuccessRegister(), "Your registration completed");
		registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_04_Duplicate_Email() {

		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.senKeyToFirstNameField(firstName);
		registerPage.senKeyToLastNameField(lastName);
		registerPage.senKeyToEmailField(emailAddress);
		registerPage.senKeyToPasswordField(password);
		registerPage.senKeyToConfirmPasswordField(password);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getTextOfDuplicateEmail(), "The specified email already exists");



	}

	@Test
	public void TC_05_Pass_Less_Than_6Character() {
		
		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.senKeyToFirstNameField(firstName);
		registerPage.senKeyToLastNameField(lastName);
		registerPage.senKeyToEmailField(emailAddress);
		registerPage.senKeyToPasswordField("123");
		registerPage.senKeyToConfirmPasswordField("123");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getTextOfErrorPassword(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Incorrect_Confirm_Password() {
		
		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.senKeyToFirstNameField(firstName);
		registerPage.senKeyToLastNameField(lastName);
		registerPage.senKeyToEmailField(emailAddress);
		registerPage.senKeyToPasswordField(password);
		registerPage.senKeyToConfirmPasswordField("123");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getTextOfErrorConfirmPassword(), "The password and confirmation password do not match.");	
		

	}

	@AfterClass
	public void afterClass() {
	}


}
