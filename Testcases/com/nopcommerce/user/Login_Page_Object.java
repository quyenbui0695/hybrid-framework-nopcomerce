package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;


public class Login_Page_Object {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress;
	private String firstName = "Mint";
	private String lastName = "Kan";
	private String password = "Abc@123";
	private String invalidEmailAddress;
	private String notExistEmailAddress;
	private String incorrectPassword;
	
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject (driver);
		registerPage = new RegisterPageObject (driver);

		emailAddress = "mint" + generateFakeNumber() + "@hotmail.com";
		notExistEmailAddress = "mint" + generateFakeNumber() + "@gmail.com";
		incorrectPassword = "123123";
		invalidEmailAddress = "!@#$%^&*";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		

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
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextOfEmailTextbox(), "Please enter your email");
	
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driver);
		loginPage.sendKeyToEmailTextbox(invalidEmailAddress);
		loginPage.sendKeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextOfEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_NotExisting_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driver);
		loginPage.sendKeyToEmailTextbox(notExistEmailAddress);
		loginPage.sendKeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextAboveEmailTextbox(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");


	}

	@Test
	public void Login_04_NotEnterPassword_ValidEmail() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driver);
		loginPage.sendKeyToEmailTextbox(emailAddress);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextAboveEmailTextbox(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_ValidEmail_IncorrectPassword() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driver);
		loginPage.sendKeyToEmailTextbox(emailAddress);
		loginPage.sendKeyToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextAboveEmailTextbox(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	
	}

	@Test
	public void Login_06_Login_Success() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driver);
		loginPage.sendKeyToEmailTextbox(emailAddress);
		loginPage.sendKeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountDisplay());

		

	}

	@AfterClass
	public void afterClass() {
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
