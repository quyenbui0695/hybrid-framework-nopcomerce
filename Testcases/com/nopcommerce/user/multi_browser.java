package com.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;


public class multi_browser  extends BaseTest{
	private WebDriver driverTestClass;
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

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);
		

		
		homePage = new HomePageObject(driverTestClass);
		loginPage = new LoginPageObject (driverTestClass);
		registerPage = new RegisterPageObject (driverTestClass);

		emailAddress = "mint" + generateFakeNumber() + "@hotmail.com";
		notExistEmailAddress = "mint" + generateFakeNumber() + "@gmail.com";
		incorrectPassword = "123123";
		invalidEmailAddress = "!@#$%^&*";


		

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
		loginPage = new LoginPageObject (driverTestClass);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextOfEmailTextbox(), "Please enter your email");
	
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driverTestClass);
		loginPage.sendKeyToEmailTextbox(invalidEmailAddress);
		loginPage.sendKeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextOfEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_NotExisting_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driverTestClass);
		loginPage.sendKeyToEmailTextbox(notExistEmailAddress);
		loginPage.sendKeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextAboveEmailTextbox(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");


	}

	@Test
	public void Login_04_NotEnterPassword_ValidEmail() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driverTestClass);
		loginPage.sendKeyToEmailTextbox(emailAddress);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextAboveEmailTextbox(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_ValidEmail_IncorrectPassword() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driverTestClass);
		loginPage.sendKeyToEmailTextbox(emailAddress);
		loginPage.sendKeyToPasswordTextbox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorTextAboveEmailTextbox(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	
	}

	@Test
	public void Login_06_Login_Success() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject (driverTestClass);
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
