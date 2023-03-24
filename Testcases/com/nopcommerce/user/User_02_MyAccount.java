package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.pageGeneratorManagement;
import pageObject.AddressedPageObject;
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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_02_MyAccount extends BaseTest {
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

	private String gender = "gender-male";
	private String editFirstName = "FirstName";
	private String textFirstName = "Mina";
	private String editLastName = "LastName";
	private String textLastName = "Jan";
	private String dayOfBirth = "DateOfBirthDay";
	private String valueDayOfBirth = "22";
	private String monthOfBirth = "DateOfBirthMonth";
	private String valueMonthOfBirth = "August";
	private String yearOfBirth = "DateOfBirthYear";
	private String valueYearOfBirth = "1999";
	private String companyName = "Company";
	private String textCompanyName = "NoWhere";
	private String email = "Email";
	private String textEmail = "qana27@gmail.com";

	
	
@Parameters ("browser")
@BeforeClass
public void beforeClass(String browserName) {
driver = getBrowserDriver (browserName);
homePage = pageGeneratorManagement.getHomePage(driver);




emailAddress = "mint" + BasePage.generateFakeNumber() + "@hotmail.com";
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
public void updateCustomerInfo() {	
	myaccountPage = registerPage.clickToMyaccountLink(driver);
	myaccountPage.selectGenderRadioButton(gender);
	myaccountPage.sendKeysToElements(textFirstName, editFirstName);
	myaccountPage.sendKeysToElements(textLastName, editLastName);
	myaccountPage.sendKeysToElements(textEmail, email);
	myaccountPage.sendKeysToElements(textCompanyName, companyName);
//  myaccountPage.selectDateOfBirth(valueDayOfBirth, dayOfBirth);
//	myaccountPage.selectDateOfBirth(valueMonthOfBirth, monthOfBirth);
//	myaccountPage.selectDateOfBirth(valueYearOfBirth, yearOfBirth);
	myaccountPage.clickSaveButton();
	
	Assert.assertEquals(myaccountPage.getTextOfTextboxElement(editFirstName), textFirstName);
	Assert.assertEquals(myaccountPage.getTextOfTextboxElement(editLastName), textLastName);
	Assert.assertEquals(myaccountPage.getTextOfTextboxElement(email), textEmail);
	Assert.assertEquals(myaccountPage.getTextOfTextboxElement(companyName), textCompanyName);
	

	
}

}
