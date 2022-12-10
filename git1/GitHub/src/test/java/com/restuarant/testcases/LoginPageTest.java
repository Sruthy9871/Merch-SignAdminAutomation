package com.restuarant.testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.restuarant.base.BaseClass;
import com.restuarant.pages.HomePage;
import com.restuarant.pages.LoginPage;

public class LoginPageTest extends BaseClass{
	//LoginPage loginPage;
	public HomePage hp;
  @Test(priority = 1, enabled = true)
  public void verifyLogo() {
	  String url = "https://qalegend.com/restaurant/login";
	  String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, url);
  }
  @Parameters({"invalidusername","invalidpassword"})
  @Test(priority = 2, enabled = true)
  public void invalidLogin(String username, String password) throws InterruptedException
  {
	  hp=loginPage.login(username,password);
	  String url = "https://qalegend.com/restaurant/login";
	  String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, url);
	 
  }
  
  @Parameters({"username","invalidpassword"})
  @Test(priority = 3, enabled = true)
  public void invalidPassword(String username, String password) throws InterruptedException
  {
	  hp=loginPage.login(username,password);
	  String url = "https://qalegend.com/restaurant/login";
	  String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, url);
	 
  }
  @Parameters({"invalidusername","password"})
  @Test(priority = 4, enabled = true)
  public void invalidUsername(String username, String password) throws InterruptedException
  {
	  hp=loginPage.login(username,password);
	  String url = "https://qalegend.com/restaurant/login";
	  String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, url);
	 
  }
  
  
  @Parameters({"blankUsername","password"})
  @Test(priority = 5, enabled = true)
  public void blankUsername(String username, String password) throws InterruptedException
  {
	  hp=loginPage.login(username,password);
	  String url = "https://qalegend.com/restaurant/login";
	  String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, url);
	 
  }
  @Parameters({"invalidusername","blankPassword"})
  @Test(priority = 6, enabled = true)
  public void blankPassword(String username, String password) throws InterruptedException
  {
	  hp=loginPage.login(username,password);
	  String url = "https://qalegend.com/restaurant/login";
	  String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, url);
	 
  }
  @Parameters({"blankUsername","blankPassword"})
  @Test(priority = 7, enabled = true)
  public void blankUsernamePassword(String username, String password) throws InterruptedException
  {
	  hp=loginPage.login(username,password);
	  String url = "https://qalegend.com/restaurant/login";
	  String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, url);
	 
  }
  
//  @Parameters({"username","password"})
  @Test(priority = 8, enabled = true)
  public void login() throws InterruptedException
  {
	  hp=loginPage.login(prop.getProperty("username") ,prop.getProperty("password"));
	  boolean adminvisible = hp.admin();
	  Assert.assertEquals(true, adminvisible);
	 
  }

}
