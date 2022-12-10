package com.restuarant.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.restuarant.base.BaseClass;

public class PeoplesPage extends BaseClass{
	public PeoplesPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[4]/a")
	WebElement People;
	
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[4]/ul/li[1]/a/span")
	WebElement Waiter;
	@FindBy(xpath="//*[@id=\"Table\"]/thead/tr/th[1]")
	WebElement waiterText;
	
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[4]/ul/li[2]/a/span")
	WebElement customer;
	@FindBy(xpath="//*[@id=\"Table\"]/thead/tr/th[1]")
	WebElement customerText;
	
	@FindBy(xpath="//*[@id=\"Table_filter\"]/label/input")
	WebElement waiterSearch;
	
	
	@FindAll(@FindBy(xpath="//*[@id=\"Table\"]/tbody/tr"))
	List<WebElement> totalWaiters; 
	
	@FindBy(xpath="//*[@id=\"Table_filter\"]/label/input")
	WebElement customerSearch;
	
	
	@FindAll(@FindBy(xpath="//*[@id=\"Table\"]/tbody/tr"))
	List<WebElement> totalCustomer; 
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addCustomer;
	
	@FindBy(id="CustomerName")
	WebElement customerName;
	@FindBy(id="CustomerPhone")
	WebElement customerPhone;
	@FindBy(id="CustomerEmail")
	WebElement customerEmail;
	@FindBy(id="CustomerDiscount")
	WebElement customerDiscount;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	
public void submitMethod()
	
	{
	submit.click();
	}
public void customerDiscountMethod(String email)
	
	{
	customerDiscount.sendKeys(email);
	}
	
public void customerEmailMethod(String email)
	
	{
	customerEmail.sendKeys(email);
	}
	
public void customerPhoneMethod(String phone)
	
	{
	customerPhone.sendKeys(phone);
	}
	public void customerNameMethod(String name)
	
	{
		customerName.sendKeys(name);
	}
	
	public void addCustomerMethod()
	{
		addCustomer.click();
		
	}
	
	public void peopleMethod()
	{
		People.click();
	}
	public void WaiterMethod()
	{
		Waiter.click();
	}
	public WebElement WaiterText()
	{
		return waiterText;
	}
	
	public void WaiterSearch(String text)
	{
		waiterSearch.clear();
		waiterSearch.sendKeys(text);
	}
	
	  public int totalWaiters() { List<WebElement> r= totalWaiters; int i=0;
	  for(WebElement a:totalWaiters) { i++; } return i; }
	 
	
	public void CustomerMethod()
	{
		customer.click();
	}
	public WebElement CustomerText()
	{
		return customerText;
	}
	
	public void CustomerSearch(String text)
	{
		customerSearch.clear();
		customerSearch.sendKeys(text);
	}
	public int totalCustomer()
	{
		List<WebElement> r= totalCustomer;
		int i=0;
		for(WebElement a:totalCustomer)
		{
			i++;
		}
		return i;
	}
}
