package com.restuarant.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.restuarant.base.BaseClass;

public class SalesPage extends BaseClass{
	


	public SalesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[5]/a/span")
	WebElement Sales;
	
	@FindBy(xpath="/html/body/div[2]/h3")
	WebElement salesText;
	
	public void SalesMethod()
	{
		Sales.click();
	}
	public String SalesText()
	{
		return salesText.getText();
	}

}
