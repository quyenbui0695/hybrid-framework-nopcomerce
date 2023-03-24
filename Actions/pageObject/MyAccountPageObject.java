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
		public void selectGenderRadioButton( String dynamicValue) {
			waitforElementVisible(driver, MyAccountUI.DYNAMIC_RADIO_BUTTON_AT_MY_ACCOUNT_AREA, dynamicValue);
			clickToElement(driver, MyAccountUI.DYNAMIC_RADIO_BUTTON_AT_MY_ACCOUNT_AREA, dynamicValue);
			
		}
		public void sendKeysToElements(String dynamicValue,  String textValue) {
			//waitforElementClickable(driver, MyAccountUI.DYNAMIC_TEXTBOX_AT_MY_ACCOUNT_AREA, dynamicValue);
			//clickToElement(driver, MyAccountUI.DYNAMIC_TEXTBOX_AT_MY_ACCOUNT_AREA, dynamicValue);
			sendKeyToElement(driver, MyAccountUI.DYNAMIC_TEXTBOX_AT_MY_ACCOUNT_AREA, dynamicValue, textValue);
			
		}
		public void clickSaveButton() {
			waitforElementVisible(driver, MyAccountUI.SAVE_BUTTON);
			clickToElement(driver, MyAccountUI.SAVE_BUTTON);
			
		}
		public void selectDateOfBirth(String dynamicValue,  String textValue) {
			//waitforElementVisible(driver, MyAccountUI.DYNAMIC_DATE_OF_BIRTH_AT_MY_ACCOUNT_AREA);
			selectItemInDefaultDropdown(driver, MyAccountUI.DYNAMIC_DATE_OF_BIRTH_AT_MY_ACCOUNT_AREA, dynamicValue, textValue);
			
		}



		public Object getTextOfTextboxElement( String dynamicValue) {
			waitforElementVisible(driver, MyAccountUI.DYNAMIC_TEXTBOX_AT_MY_ACCOUNT_AREA, dynamicValue);

			return getTextOfElement(driver, MyAccountUI.DYNAMIC_TEXTBOX_AT_MY_ACCOUNT_AREA, dynamicValue);
		}
}
