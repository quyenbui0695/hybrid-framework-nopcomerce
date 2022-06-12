package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.pageGeneratorManagement;
import pageObject.AddressedPageObject;
import pageObject.CustomerInfoPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.OrdersPageObject;
import pageObject.PasswordPageObject;
import pageObject.ProductReviewPageObject;
import pageObject.ProductsPageObject;
import pageObject.RegisterPageObject;
import pageObject.RewardPageObject;
import pageObject.SubcriptionsPageObject;


public class  Apply_BasePage_5_SwitchPage extends BaseTest {
	private WebDriver driver;


	private String emailAddress;
	private String firstName = "Mint";
	private String lastName = "Kan";
	private String password = "Abc@123";
	private String day = "22";
	private String month = "June";
	private String year = "1995";

	
	
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myaccountPage;
	private MyAccountPageObject CustomerInfoPage;
	private AddressedPageObject AddressedPage;
	private OrdersPageObject OrdersPage;
	private ProductsPageObject ProductPage;
	private SubcriptionsPageObject SubcriptionPage;
	private RewardPageObject RewardsPage;
	private PasswordPageObject ChangePassPage;
	private ProductReviewPageObject ProductReviewPage;

	@Parameters ("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver (browserName);
		homePage = pageGeneratorManagement.getHomePage(driver);




		emailAddress = "mint" + generateFakeNumber() + "@hotmail.com";
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		registerPage.selectMaleRadioButton();
		registerPage.senKeyToFirstNameField(firstName);
		registerPage.senKeyToLastNameField(lastName);
		registerPage.selectDayOfBirth(day);
		registerPage.selectMonthOfBirth(month);
		registerPage.selectYearOfBirth(year);
		registerPage.checkCheckBox();
		registerPage.senKeyToEmailField(emailAddress);
		registerPage.senKeyToPasswordField(password);
		registerPage.senKeyToConfirmPasswordField(password);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getTextOfSuccessRegister(), "Your registration completed");
		

	}

	@Test
	public void SwitchPage() {
		myaccountPage = registerPage.clickToMyaccountLink(driver);
		Assert.assertTrue(myaccountPage.isMyaccountdisplayed());
		
		AddressedPage = myaccountPage.openAddressedPage(driver);

		OrdersPage = AddressedPage.openOrdersPage(driver);
	}


	

	@AfterClass
	public void afterClass() {
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
