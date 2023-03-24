package pageUIs;

public class MyAccountUI {
	public static final String CUSTOMERINFOLINK = "//a[contains(text(),'Customer info')]";
	public static final String ADDRESSD = "//div[contains (@class, 'account-navigation')]//a[contains(text(), 'Addresses')]";
	public static final String ORDERS = "//div[contains (@class, 'account-navigation')]//a[contains(text(),'Orders')]";
	public static final String PRODUCTS = "//div[contains (@class, 'account-navigation')]//a[contains(text(),'products')]";
	public static final String SUBCRIPTIONS = "//div[contains (@class, 'account-navigation')]//a[contains(text(),'subscriptions')]";
	public static final String REWARDS = "//div[contains (@class, 'account-navigation')]//a[contains(text(),'Reward')]";
	public static final String PASSWORDCHANGE = "//div[contains (@class, 'account-navigation')]//a[contains(text(),'password')]";
	public static final String PRODUCTREVIEW = "//div[contains (@class, 'account-navigation')]//a[contains(text(),'reviews')]";
	public static final String MYACCOUNT = "//div[contains(@class, 'account-navigation')]//strong[text()='My account']";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "//div[contains(@class, 'account-navigation')]//a[contains(text(), '%s')]";
	public static final String DYNAMIC_TEXTBOX_AT_MY_ACCOUNT_AREA = "//div[@class='inputs']//input[@id='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_AT_MY_ACCOUNT_AREA = "//div[@class='gender']//input[@id='%s']";
	public static final String DYNAMIC_DATE_OF_BIRTH_AT_MY_ACCOUNT_AREA = "//div[@class='date-picker-wrapper']//select[@name='%s']";
	public static final String SAVE_BUTTON = "//button[@id='save-info-button']";
	
	
	
}
