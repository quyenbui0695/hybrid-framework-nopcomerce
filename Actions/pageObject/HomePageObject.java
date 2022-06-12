package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.pageGeneratorManagement;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {

		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {

		waitforElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return  pageGeneratorManagement.getRegisterPage(driver);

	}

	public LoginPageObject clickToLoginLink() {
		waitforElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return  pageGeneratorManagement.getLoginPage(driver);
	}

	public boolean isMyAccountDisplay() {
		waitforElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);

	}

}
