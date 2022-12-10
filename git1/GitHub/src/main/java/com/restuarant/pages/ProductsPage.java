package com.restuarant.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.restuarant.base.BaseClass;
import com.restuarant.utilities.GeneralUtility;

public class ProductsPage extends BaseClass {
	GeneralUtility gu = new GeneralUtility();

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//Select[@name='Table_length']")
	WebElement show;

	@FindAll(@FindBy(xpath = "//tr[@role='row']"))
	List<WebElement> numberofrows;

	@FindBy(id = "Supplier")
	public WebElement supplier;
	
	@FindBy(xpath = "//button[text() ='Apply Filter']")
	WebElement applyFilter;

	@FindBy(xpath = "//div[contains(text(),'Showing ')]")
	WebElement showingResults;
	@FindBy(xpath="//*[@id=\"Table\"]/tbody/tr/td[7]/div/a[2]/i")
	WebElement viewProduct;
	
	@FindBy(xpath="//h1[contains(text(),'TVM Apple shake')]")
	WebElement titleFromViewProduct;
	@FindBy(xpath="//*[@id=\"viewModal\"]/div/div[3]/button")
	WebElement CloseViewProduct;
	
	@FindBy(xpath="//td[contains(.,'TVM Apple shake')]")
	WebElement textOfRetriedProduct;

	@FindBy(xpath="//a[@href='products/delete/322']")WebElement delete;
	
	public WebElement elementProductSearched() {
		return textOfRetriedProduct;
	}
	
	public void deleteMethod() {
		delete.click();
	}
	public WebElement showDropdown() {
		return show;

	}

	public int totalRows() {
		List<WebElement> r = numberofrows;
		int i = 0;
		for (WebElement a : numberofrows) {
			i++;
		}
		return i;
	}

	public StoresPage str() {
		WebElement sh = showDropdown();
		gu.SelectByvalueMethod(sh, "25");
		return new StoresPage();
	}

	public void Supplier(String name) {
		WebElement splier = supplier;
		gu.SelectByVisibleTextmethod(splier, name);
	}

	public void ApplyFilter() {
		applyFilter.click();
	}

	public boolean Results() {
		return showingResults.isDisplayed();
	}
	
	public void ProductView()
	{
		viewProduct.click();
	}
	public String getTextOfProduct()
	{
		return titleFromViewProduct.getText();
	}

	/*
	 * public void CloseProductView() { CloseViewProduct.click(); }
	 */
	public String getTextOfProductToBeSearched()
	{
	return textOfRetriedProduct.getText();	
	}
	
	public StoresPage CloseProductView()
	{
		CloseViewProduct.click();  
		return new StoresPage();
	}

}
