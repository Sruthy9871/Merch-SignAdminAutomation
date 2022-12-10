package com.restuarant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.restuarant.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"login-modal\"]/div/div/form/input[3]")
	WebElement submit;
	
	@FindBy(linkText="https://qalegend.com/restaurant/files/Setting/ea28fde2b923e00cc7c205fd95f0b5bb.jpg")
	WebElement logo;
	
	public boolean validateLogo()
	{
		logo.isDisplayed();
		return true;
	}
	
	public HomePage login(String name, String passwd) throws InterruptedException {
		uname.clear();
		uname.sendKeys(name);
		password.clear();
		password.sendKeys(passwd);
		Thread.sleep(3000);
		submit.click();
	   return new HomePage();
	}


}
