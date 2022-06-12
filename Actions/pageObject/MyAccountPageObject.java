package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAccountUI;

public class MyAccountPageObject extends BasePage{
	public WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {

		this.driver = driver;
		
	}
		public boolean isMyaccountdisplayed () {
			waitforElementVisible(driver, MyAccountUI.MYACCOUNT);
			return isElementDisplayed(driver, MyAccountUI.MYACCOUNT);
			
	}
}
