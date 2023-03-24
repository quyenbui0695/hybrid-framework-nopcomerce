package commons;

import java.awt.Desktop.Action;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObject.AddressedPageObject;
import pageObject.CustomerInfoPageObject;
import pageObject.MyAccountPageObject;
import pageObject.OrdersPageObject;
import pageObject.PasswordPageObject;
import pageObject.ProductReviewPageObject;
import pageObject.ProductsPageObject;
import pageObject.RewardPageObject;
import pageObject.SubcriptionsPageObject;
import pageUIs.MyAccountUI;
import pageUIs.RegisterPageUI;

public class BasePage {

//Nhiệm vụ để mở url	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}

// đây là kiểu trả về dữ liêu (trả về title) nên không để là void dc
	public String getTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void forwardToPage(WebDriver driver) {

		driver.navigate().forward();

	}

	public void refreshPage(WebDriver driver) {

		driver.navigate().refresh();

	}

	public Alert waitAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {

		waitAlertPresence(driver).accept();

	}

	public void dismissAlert(WebDriver driver) {

		waitAlertPresence(driver).dismiss();

	}

	public String getTextAlert(WebDriver driver) {

		return waitAlertPresence(driver).getText();

	}

	public void sendkeyAlert(WebDriver driver, String textValue) {

		waitAlertPresence(driver).sendKeys(textValue);

	}

	public void switchWindowbyID(WebDriver driver, String WindowID) {

		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			if (!id.equals(WindowID)) {
				driver.switchTo().window(id);
				break;

			}
		}
	}

	public void switchWindowbyTitle(WebDriver driver, String tabTitle) {

		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();

			if (actualTitle.equals(tabTitle)) {
				break;
			}

		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {

		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));

	}

	private WebElement findElement(WebDriver driver, String xpathLocator) {

		return driver.findElement(getByXpath(xpathLocator));

	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		findElement(driver, xpathLocator).click();

	}

	public void clickToElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		findElement(driver, castRestParameter(xpathLocator, dynamicValues)).click();

	}

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = findElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);

	}

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue, String... dynamicValues) {
		WebElement element = findElement(driver, castRestParameter(xpathLocator, dynamicValues ));
		element.clear();
		element.sendKeys(textValue);

	}

	public String getTextOfElement(WebDriver driver, String xpathLocator) {
		return findElement(driver, xpathLocator).getText();
		
	}
	
	public String getTextOfElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return findElement(driver, castRestParameter(xpathLocator, dynamicValues)).getText();

	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textValue) {
		Select select = new Select(findElement(driver, xpathLocator));
		
		select.selectByValue(textValue);
		
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textValue, String... dynamicValues) {
		Select select = new Select(findElement(driver, castRestParameter(xpathLocator, dynamicValues)));

		select.selectByValue(textValue);

	}



	public boolean isDropDownListMutiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(findElement(driver, xpathLocator));

		return select.isMultiple();

	}

	public String getSelectedItemInDropDown(WebDriver driver, String xpathLocator) {

		Select select = new Select(findElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();

	}

	public void selectItemInCustomDropdown(WebDriver driver, String xpathLocator, String childItemLocator,
			String expectedItem) {
		findElement(driver, xpathLocator).click();

		sleepInSecond(5);
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(5);
				item.click();
				sleepInSecond(5);
				;
				break;
			}
		}
	}

	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public String getAtributeValue(WebDriver driver, String xpathLocator, String atributeName) {

		return findElement(driver, xpathLocator).getAttribute(atributeName);
	}

	public String getCssValue(WebDriver driver, String xpathLocator, String propertyName) {

		return findElement(driver, xpathLocator).getCssValue(propertyName);

	}

	public String getHexaColorFromRGBA(String rgbavalue) {
		return Color.fromString(rgbavalue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {

		return getListWebElement(driver, xpathLocator).size();

	}

	public void checkTheCheckBoxOrRadio(WebDriver driver, String xpathLocator) {
		WebElement element = findElement(driver, xpathLocator);

		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckBox(WebDriver driver, String xpathLocator) {
		WebElement element = findElement(driver, xpathLocator);

		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {

		return findElement(driver, xpathLocator).isDisplayed();

	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... dynamicValues) {

		return findElement(driver, castRestParameter(xpathLocator, dynamicValues)).isDisplayed();

	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator) {

		return findElement(driver, xpathLocator).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {

		return findElement(driver, xpathLocator).isEnabled();
	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {

		driver.switchTo().frame(findElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);

		action.moveToElement(findElement(driver, xpathLocator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);

		action.doubleClick(findElement(driver, xpathLocator)).perform();
	}

	public void uploadFile(WebDriver driver, String xpathLocator) throws InterruptedException {

		String projectPath = System.getProperty("user.dir");
		String file1 = "1.jpg";
		String file2 = "2.jpg";
		String file3 = "3.jpg";
		String file4 = "4.jpg";

		// đường dẫn upload file

		String uploadFileFolderPath = projectPath + File.separator + "upload_files" + File.separator;
		String path1 = uploadFileFolderPath + file1;
		String path2 = uploadFileFolderPath + file2;
		String path3 = uploadFileFolderPath + file3;
		String path4 = uploadFileFolderPath + file4;
		By uploadfilebutton = getByXpath(xpathLocator);
		driver.findElement(uploadfilebutton).sendKeys(path1 + "\n" + path2 + "\n" + path3 + "\n" + path4);

		Thread.sleep(3000);

		// Click upload element at each file:
		List<WebElement> uploadButton = getListWebElement(driver, xpathLocator);
		for (WebElement button : uploadButton) {
			button.click();
			;
			Thread.sleep(2000);

		}
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = findElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub

	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", findElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", findElement(driver, xpathLocator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathLocator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')",
				findElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				findElement(driver, xpathLocator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {

				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				findElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				findElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitforElementVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));

	}

	public void waitforElementVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 10);

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(castRestParameter(xpathLocator, dynamicValues))));

	}

	public void waitforAllElementsVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}

	public void waitforAllElementsVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 10);

		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(castRestParameter(xpathLocator, dynamicValues))));

	}

	public void waitforElementInvisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));

	}

	public void waitforAllElementsInvisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}

	public void waitforElementClickable(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));

	}

	public void waitforElementClickable(WebDriver driver, String xpathLocator, String... dynamicValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(castRestParameter(xpathLocator, dynamicValues))));


	}

	public static BasePage getBasePage() {
		return new BasePage();

	}

	public CustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {

		waitforElementVisible(driver, MyAccountUI.CUSTOMERINFOLINK);
		clickToElement(driver, MyAccountUI.CUSTOMERINFOLINK);
		return pageGeneratorManagement.getCustomerInfoPage(driver);
	}

	public AddressedPageObject openAddressedPage(WebDriver driver) {

		waitforElementVisible(driver, MyAccountUI.ADDRESSD);
		clickToElement(driver, MyAccountUI.ADDRESSD);
		return pageGeneratorManagement.getAddressedPage(driver);
	}

	public OrdersPageObject openOrdersPage(WebDriver driver) {

		waitforElementVisible(driver, MyAccountUI.ORDERS);
		clickToElement(driver, MyAccountUI.ORDERS);
		return pageGeneratorManagement.getOrdersPage(driver);
	}

	public ProductsPageObject openProductsPage(WebDriver driver) {

		waitforElementVisible(driver, MyAccountUI.PRODUCTS);
		clickToElement(driver, MyAccountUI.PRODUCTS);
		return pageGeneratorManagement.getProductsPage(driver);
	}

	public SubcriptionsPageObject openSupcriptionsPage(WebDriver driver) {

		waitforElementVisible(driver, MyAccountUI.SUBCRIPTIONS);
		clickToElement(driver, MyAccountUI.SUBCRIPTIONS);
		return pageGeneratorManagement.geSubcriptionsPage(driver);
	}

	public RewardPageObject openRewardsPage(WebDriver driver) {

		waitforElementVisible(driver, MyAccountUI.REWARDS);
		clickToElement(driver, MyAccountUI.REWARDS);
		return pageGeneratorManagement.getRewardPage(driver);
	}

	public PasswordPageObject openPasswordChangePage(WebDriver driver) {

		waitforElementVisible(driver, MyAccountUI.PASSWORDCHANGE);
		clickToElement(driver, MyAccountUI.PASSWORDCHANGE);
		return pageGeneratorManagement.getPasswordPage(driver);
	}

	public ProductReviewPageObject openProductReviewPage(WebDriver driver) {

		waitforElementVisible(driver, MyAccountUI.PRODUCTREVIEW);
		clickToElement(driver, MyAccountUI.PRODUCTREVIEW);
		return pageGeneratorManagement.getProductReviewPage(driver);
	}

	public MyAccountPageObject clickToMyaccountLink(WebDriver driver) {
		waitforElementVisible(driver, RegisterPageUI.MYACCOUNTLINK);
		clickToElement(driver, RegisterPageUI.MYACCOUNTLINK);
		return pageGeneratorManagement.getMyAccountPage(driver);

	}

	public String castRestParameter(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}
	

	public void openDynamicMorePage(WebDriver driver, String PageName) {

		waitforElementVisible(driver, MyAccountUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, PageName);
		clickToElement(driver, MyAccountUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, PageName);
	}

	public static int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}



}
