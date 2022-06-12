package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitforElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public String getErrorTextOfEmailTextbox() {
		waitforElementVisible(driver, LoginPageUI.ERROR_EMAIL_TEXTBOX);
		return getTextOfElement(driver, LoginPageUI.ERROR_EMAIL_TEXTBOX);
	}


	public void sendKeyToEmailTextbox(String value) {
		waitforElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, value);
		
	}

	public void sendKeyToPasswordTextbox(String password) {
		waitforElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public String getErrorTextAboveEmailTextbox() {
		waitforElementVisible(driver, LoginPageUI.ERROR_EMAIL_ABOVE_TEXTBOX);
		return getTextOfElement(driver, LoginPageUI.ERROR_EMAIL_ABOVE_TEXTBOX);
	}
	

	
	
}


