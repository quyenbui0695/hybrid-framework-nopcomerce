package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.pageGeneratorManagement;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	private 	WebDriver driver;



	public RegisterPageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public String getTextOfFirstName() {
		waitforElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getTextOfElement (driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);

	}

	public String getTextOfLastName() {
		waitforElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getTextOfElement (driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getTextOfEmail() {
		waitforElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getTextOfElement (driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getTextOfPassword() {
		waitforElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextOfElement (driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getTextOfConfirmPassword() {
		waitforElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getTextOfElement (driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void senKeyToFirstNameField(String FirstName) {
	waitforElementVisible(driver, RegisterPageUI.FIRST_NAME_FIELD);
	sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_FIELD, FirstName);

	}

	public void senKeyToLastNameField(String LastName) {
		waitforElementVisible(driver, RegisterPageUI.LAST_NAME_FIELD);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_FIELD, LastName);

	}

	public void senKeyToEmailField(String Email) {
		waitforElementVisible(driver, RegisterPageUI.EMAIL_FIELD);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_FIELD, Email);

	}

	public void senKeyToPasswordField(String Password) {
		waitforElementVisible(driver, RegisterPageUI.PASSWORD_FIELD);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_FIELD, Password);

	}

	public void senKeyToConfirmPasswordField(String confirmPassword) {
		waitforElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_FIELD);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_FIELD, confirmPassword);

	}

	public String getTextOfErrorPassword() {
		waitforElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getTextOfElement (driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getTextOfDuplicateEmail() {
		waitforElementVisible(driver, RegisterPageUI.DUPLICATE_EMAIL_MESSAGE);
		return getTextOfElement (driver, RegisterPageUI.DUPLICATE_EMAIL_MESSAGE);
	}

	public void clickToLogoutLink() {
		waitforElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		
	}
	public void clickToRegisterButton() {
		waitforElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String getTextOfSuccessRegister() {
		waitforElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getTextOfElement (driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getTextOfErrorConfirmPassword() {
		waitforElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getTextOfElement (driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void selectMaleRadioButton() {
		waitforElementVisible(driver, RegisterPageUI.GENDER_MALE);
		checkTheCheckBoxOrRadio(driver,RegisterPageUI.GENDER_MALE );

		
	}
	public void selectDayOfBirth(String expectedItem) {
		waitforElementVisible(driver, RegisterPageUI.DROPDOWNLISTDAY);
		selectItemInCustomDropdown(driver, RegisterPageUI.DROPDOWNLISTDAY, RegisterPageUI.CHILDDAY, expectedItem);
		
		
	}

	public void selectMonthOfBirth(String expectedItem) {
		waitforElementVisible(driver, RegisterPageUI.DROPDOWNLISTDAY);
		selectItemInCustomDropdown(driver, RegisterPageUI.DROPDOWNLISTMONTH, RegisterPageUI.CHILDMONTH, expectedItem);
		
	}

	public void selectYearOfBirth(String expectedItem) {
		waitforElementVisible(driver, RegisterPageUI.DROPDOWNLISTYEAR);
		selectItemInCustomDropdown(driver, RegisterPageUI.DROPDOWNLISTYEAR, RegisterPageUI.CHILDYEAR, expectedItem);
		
	}

	public void checkCheckBox() {
		waitforElementVisible(driver, RegisterPageUI.NEWSLETTERCHECKBOX);
		checkTheCheckBoxOrRadio(driver,RegisterPageUI.NEWSLETTERCHECKBOX);
		
	}


	



}
