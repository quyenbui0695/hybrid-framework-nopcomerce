package commons;

import org.openqa.selenium.WebDriver;

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

public class pageGeneratorManagement {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject (driver);
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
	
	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
		
	}
	public static AddressedPageObject getAddressedPage(WebDriver driver) {
		return new AddressedPageObject(driver);
		
	}
	public static OrdersPageObject getOrdersPage(WebDriver driver) {
		return new OrdersPageObject(driver);
		
	}
	public static ProductsPageObject getProductsPage(WebDriver driver) {
		return new ProductsPageObject(driver);
		
	}
	public static SubcriptionsPageObject geSubcriptionsPage(WebDriver driver) {
		return new SubcriptionsPageObject(driver);
		
	}
	public static RewardPageObject getRewardPage(WebDriver driver) {
		return new RewardPageObject(driver);
		
	}
	public static PasswordPageObject getPasswordPage(WebDriver driver) {
		return new PasswordPageObject(driver);
		
	}
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);

	}

}
