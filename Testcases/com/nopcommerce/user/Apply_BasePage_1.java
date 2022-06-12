package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Apply_BasePage_1 {
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  String emailAddress;
  
  //Declare (khai bao)
  BasePage basePage;
  
  
  

  @BeforeClass
  public void beforeClass() {
 System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
 driver = new FirefoxDriver();
 
 //Initial: khoi tao no len
 basePage = new BasePage();
 emailAddress = "mint" + generateFakeNumber () + "@hotmail.com";
 
 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 driver.get("https://demo.nopcommerce.com/");
 
  }
  @Test
  public void TC_01_Register_Empty_Data() {
	  
	  basePage.waitforElementClickable(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  basePage.waitforElementClickable(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='FirstName-error']"), "First name is required.");
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='LastName-error']"), "Last name is required.");
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='Email-error']"), "Email is required.");
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='Password-error']"), "Password is required.");
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	  
	  
  // driver.findElement(By.cssSelector("a.ico-register")).click();
  //driver.findElement(By.cssSelector("button.register-next-step-button")).click();
   // Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
 // Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
 // Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
 // Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
//  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
  
  }
  @Test
  public void TC_02_Invalid_Email() {
  //driver.findElement(By.cssSelector("a.ico-register")).click();	  
 // driver.findElement(By.cssSelector("input#gender-female")).click();
 // driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Mint");
 // driver.findElement(By.cssSelector("input#LastName")).sendKeys("Holland");
 // driver.findElement(By.cssSelector("input#Email")).sendKeys("Mint");
 // driver.findElement(By.cssSelector("input#Password")).sendKeys("Abc@123");
 // driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("Abc@123");
//  driver.findElement(By.cssSelector("button.register-next-step-button")).click();
//.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");  
  
  
  basePage.waitforElementClickable(driver, "//a[@class='ico-register']");
  basePage.clickToElement(driver, "//a[@class='ico-register']");
  
  basePage.waitforElementClickable(driver, "//input[@id='gender-female']");
  basePage.clickToElement(driver, "//input[@id='gender-female']");

  basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Mint");
  basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
  basePage.sendKeyToElement(driver, "//input[@id='Email']", "Mint");
  basePage.sendKeyToElement(driver, "//input[@id='Password']", "Abc@123");
  basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");
  
  basePage.clickToElement(driver, "//button[@id='register-button']");

  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id='Email-error']"), "Wrong email");  
	  
  }
 
  
  @Test
  public void TC_03_Valid_Email() {
  //driver.findElement(By.cssSelector("a.ico-register")).click();	  
 // driver.findElement(By.cssSelector("input#gender-male")).click();
  //driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Mint");
 // driver.findElement(By.cssSelector("input#LastName")).sendKeys("Holland");
 // driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
 // driver.findElement(By.cssSelector("input#Password")).sendKeys("Abc@123");
 // driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("Abc@123");
 // driver.findElement(By.cssSelector("button.register-next-step-button")).click();
 // Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");  
 // driver.findElement(By.cssSelector("a.ico-logout")).click();	  
	  
  
  
  basePage.waitforElementClickable(driver, "//a[@class='ico-register']");
  basePage.clickToElement(driver, "//a[@class='ico-register']");
  
  
  basePage.waitforElementClickable(driver, "//input[@id='gender-male']");
  basePage.clickToElement(driver, "//input[@id='gender-male']");
  
  basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Minta");
  basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
  basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
  basePage.sendKeyToElement(driver, "//input[@id='Password']", "Abc@123");
  basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");
  
  
  basePage.clickToElement(driver, "//button[@id='register-button']");

  Assert.assertEquals(basePage.getTextOfElement(driver, "//div[@class='result']"), "Your registration completed"); 
  basePage.clickToElement(driver, "//a[@class='ico-logout']");


  }
  
  @Test
  public void TC_04_Duplicate_Email() {
  //driver.findElement(By.cssSelector("a.ico-register")).click();	  
 // driver.findElement(By.cssSelector("input#gender-male")).click();
 // driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Mint");
//  driver.findElement(By.cssSelector("input#LastName")).sendKeys("Holland");
 // driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
 // driver.findElement(By.cssSelector("input#Password")).sendKeys("Abc@123");
 // driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("Abc@123");
 // driver.findElement(By.cssSelector("button.register-next-step-button")).click();
 // Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");  
  
  
  basePage.waitforElementClickable(driver, "//a[@class='ico-register']");
  basePage.clickToElement(driver, "//a[@class='ico-register']");
  
  
  basePage.waitforElementClickable(driver, "//input[@id='gender-male']");
  basePage.clickToElement(driver, "//input[@id='gender-male']");
  
  basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Minta");
  basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
  basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
  basePage.sendKeyToElement(driver, "//input[@id='Password']", "Abc@123");
  basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");
  
  
  basePage.clickToElement(driver, "//button[@id='register-button']");

  Assert.assertEquals(basePage.getTextOfElement(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");  
  
  
  }
  @Test
  public void TC_05_Pass_Less_Than_6Character() {
	 // driver.findElement(By.cssSelector("a.ico-register")).click();	  
	 // driver.findElement(By.cssSelector("input#gender-male")).click();
	//  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Mint");
	//  driver.findElement(By.cssSelector("input#LastName")).sendKeys("Holland");
	//  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
	//  driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
	//  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
	//  driver.findElement(By.cssSelector("button.register-next-step-button")).click();
	//  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
	  
	  basePage.waitforElementClickable(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  
	  basePage.waitforElementClickable(driver, "//input[@id='gender-male']");
	  basePage.clickToElement(driver, "//input[@id='gender-male']");
	  
	  basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Minta");
	  basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
	  basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.sendKeyToElement(driver, "//input[@id='Password']", "123");
	  basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
	  
	  
	  basePage.clickToElement(driver, "//button[@id='register-button']");  
	  
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");  

	  
	  

  }
  @Test
  public void TC_06_Incorrect_Confirm_Password() {
	//  driver.findElement(By.cssSelector("a.ico-register")).click();	  
	//  driver.findElement(By.cssSelector("input#gender-male")).click();
	//  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Mint");
	//  driver.findElement(By.cssSelector("input#LastName")).sendKeys("Holland");
	//  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
	//  driver.findElement(By.cssSelector("input#Password")).sendKeys("123@123");
	//  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
	//  driver.findElement(By.cssSelector("button.register-next-step-button")).click();
	//  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");   
	  
	  basePage.waitforElementClickable(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  
	  basePage.waitforElementClickable(driver, "//input[@id='gender-male']");
	  basePage.clickToElement(driver, "//input[@id='gender-male']");
	  
	  basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Minta");
	  basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
	  basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.sendKeyToElement(driver, "//input[@id='Password']", "123@123");
	  basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
	  
	  
	  basePage.clickToElement(driver, "//button[@id='register-button']");    
	  
	  Assert.assertEquals(basePage.getTextOfElement(driver, "//span[@id = 'ConfirmPassword-error']"), "The password and confirmation password do not match.");  

	  
	  
  }
  @AfterClass
  public void afterClass() {
  }
  public int generateFakeNumber () {
  Random rand = new Random ();
  return rand.nextInt(9999);
  
  
  
  }
}
