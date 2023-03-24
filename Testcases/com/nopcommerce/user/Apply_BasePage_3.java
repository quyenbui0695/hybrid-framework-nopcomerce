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

public class Apply_BasePage_3  extends BasePage {
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  String emailAddress;
  
  //Declare (khai bao)
 // BasePage basePage;
  
  
  

  @BeforeClass
  public void beforeClass() {
 System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
 driver = new FirefoxDriver();
 
 //Initial: khoi tao no len
 //basePage = new BasePage();
 
 // Hide việc khởi tạo của một đối tượng
// basePage = getBasePage();
 emailAddress = "mint" + generateFakeNumber () + "@hotmail.com";
 
 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 driver.get("https://demo.nopcommerce.com/");
 
  }
  @Test
  public void TC_01_Register_Empty_Data() {
	  
	  waitforElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  waitforElementClickable(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id='FirstName-error']"), "First name is required.");
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id='LastName-error']"), "Last name is required.");
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id='Email-error']"), "Email is required.");
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id='Password-error']"), "Password is required.");
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	  
	  

  }
  @Test
  public void TC_02_Invalid_Email() {

  
  
  waitforElementClickable(driver, "//a[@class='ico-register']");
  clickToElement(driver, "//a[@class='ico-register']");
  
  waitforElementClickable(driver, "//input[@id='gender-female']");
  clickToElement(driver, "//input[@id='gender-female']");

  sendKeyToElement(driver, "//input[@id='FirstName']", "Mint");
  sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
  sendKeyToElement(driver, "//input[@id='Email']", "Mint");
  sendKeyToElement(driver, "//input[@id='Password']", "Abc@123");
  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");
  
  clickToElement(driver, "//button[@id='register-button']");

  Assert.assertEquals(getTextOfElement(driver, "//span[@id='Email-error']"), "Wrong email");  
	  
  }
 
  @Test
  public void TC_03_Valid_Email() {
  
	  
  
  
  waitforElementClickable(driver, "//a[@class='ico-register']");
  clickToElement(driver, "//a[@class='ico-register']");
  
  
  waitforElementClickable(driver, "//input[@id='gender-male']");
  clickToElement(driver, "//input[@id='gender-male']");
  
  sendKeyToElement(driver, "//input[@id='FirstName']", "Minta");
  sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
  sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
  sendKeyToElement(driver, "//input[@id='Password']", "Abc@123");
  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");
  
  
  clickToElement(driver, "//button[@id='register-button']");

  Assert.assertEquals(getTextOfElement(driver, "//div[@class='result']"), "Your registration completed"); 
  clickToElement(driver, "//a[@class='ico-logout']");


  }
 
  @Test
  public void TC_04_Duplicate_Email() {

  
  waitforElementClickable(driver, "//a[@class='ico-register']");
  clickToElement(driver, "//a[@class='ico-register']");
  
  
  waitforElementClickable(driver, "//input[@id='gender-male']");
  clickToElement(driver, "//input[@id='gender-male']");
  
  sendKeyToElement(driver, "//input[@id='FirstName']", "Minta");
  sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
  sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
  sendKeyToElement(driver, "//input[@id='Password']", "Abc@123");
  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "Abc@123");
  
  
  clickToElement(driver, "//button[@id='register-button']");

  Assert.assertEquals(getTextOfElement(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");  
  
  
  }
  @Test
  public void TC_05_Pass_Less_Than_6Character() {

	  waitforElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  
	  waitforElementClickable(driver, "//input[@id='gender-male']");
	  clickToElement(driver, "//input[@id='gender-male']");
	  
	  sendKeyToElement(driver, "//input[@id='FirstName']", "Minta");
	  sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
	  sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendKeyToElement(driver, "//input[@id='Password']", "123");
	  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
	  
	  
	  clickToElement(driver, "//button[@id='register-button']");  
	  
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");  

	  
	  

  }
  @Test
  public void TC_06_Incorrect_Confirm_Password() {
	
	  
	  waitforElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  
	  waitforElementClickable(driver, "//input[@id='gender-male']");
	  clickToElement(driver, "//input[@id='gender-male']");
	  
	  sendKeyToElement(driver, "//input[@id='FirstName']", "Minta");
	  sendKeyToElement(driver, "//input[@id='LastName']", "Holland");
	  sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendKeyToElement(driver, "//input[@id='Password']", "123@123");
	  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
	  
	  
	  clickToElement(driver, "//button[@id='register-button']");    
	  
	  Assert.assertEquals(getTextOfElement(driver, "//span[@id = 'ConfirmPassword-error']"), "The password and confirmation password do not match.");  

	  
	  
  }
  @AfterClass
  public void afterClass() {
  }

  
  
  }

