package com.restuarant.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.restuarant.base.BaseClass;

public class StoresPage extends BaseClass{
	public StoresPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text() ='Stores']")
	WebElement storesPage;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchElement;
	
	@FindAll(@FindBy(xpath="//tr[@role='row'][2]|//tr[@class='odd']|//tr[@class='even']"))
	List<WebElement> totalStores; 
	
	@FindBy(xpath="//*[@id=\"Table\"]/tbody/tr[1]/td[6]/div/a[2]/i")
	WebElement Edit;
	
	@FindBy(xpath="//*[@id=\"Table\"]/thead/tr/th[1]")
	WebElement StoresText;

	@FindBy(xpath = "//input[@type='search']|//input[@class='form-control input-sm']")
	WebElement SearchStores;
	
	public void SearchStore(String store)
	{
		searchElement.sendKeys(store);
	}
	public void StoresPageMethod() {
		storesPage.click();  //changes
	}

	public String textStores()
	{
		return StoresText.getText();
	}

	public void searchStores(String text)
	{
		StoresText.sendKeys(text);
	}
	public int totalStores()
	{
		List<WebElement> r= totalStores;
		int i=0;
		for(WebElement a:totalStores)
		{
			i++;
		}
		return i;
	}

	public WebElement editTool()
	{
		return Edit;
	}
	
	public ExpensePage CloseProductView()
	{
		storesPage.click();
		return new ExpensePage(driver);
	}

}
