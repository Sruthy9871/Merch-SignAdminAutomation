package com.restuarant.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.restuarant.base.BaseClass;


public class ExpensePage extends BaseClass{
	public WebDriver driver;

	public ExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[6]/a/span")
	WebElement Expenses;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchExpense;
	
	@FindBy(xpath="/html/body/div[2]/h3")
	WebElement expenseText;
	
	@FindBy(xpath="//*[@class='btn btn-add btn-lg']")
	WebElement AddExpenseButton;
	
	@FindBy(xpath="//*[@id=\"Reference\"]")
	WebElement Reference;
	
	@FindBy(xpath="//*[@id=\"AddExpence\"]/div/div/div/button/span")
	WebElement closeAddExpence;
	
	@FindBy(xpath="//div[@class='datepicker-days']")
	WebElement date;
	
	@FindBy(xpath="//*[@id=\"Date\"]")
	WebElement dateField;
	
	@FindBy(xpath="//*[@name='category']")
	WebElement category;
	
	@FindBy(xpath="//*[@name='store_id']")
	WebElement store;
	
	@FindBy(xpath="//input[@type='number']")
			WebElement amount;
	
	@FindBy(xpath="//*[@id=\"attachment\"]")
	WebElement attachment;
	
	@FindBy(xpath="//*[@id=\"table\"]//tbody//tr[1]")
	WebElement retrievedExpense;
	
	@FindBy(xpath="//*[@id=\"addform\"]/div[2]/button[2]")
WebElement submit;
	
	@FindBy(xpath="//*[@id=\"table\"]/tbody/tr[1]/td[7]/div/a[1]/i")
	WebElement deleteExpense;
	
	@FindBy(xpath="//div[@class='sweet-alert showSweetAlert visible']")
	WebElement alert;
	/*
	 * @FindBy(xpath="//button[@class='confirm']") WebElement confirmButton;
	 * 
	 *  }
	 */
	@FindAll(@FindBy(xpath="//a[@class='btn btn-default' and @href='javascript:void(0)'][1]"))
	List<WebElement> deleteAll; 
	
	@FindBy(css="button.confirm")
	WebElement confirmButton;
	@FindBy(xpath="//div[7]/p")//p[contains(text(),'the data has been deleted.')]")
	WebElement deleteMessage;
	
	@FindBy(css="button.cancel")
	WebElement cancel;

	
	public String message()
	
	{
		return deleteMessage.getText();
	}
	
	public void ButtonConfirm() { 
		confirmButton.click();
	}

	
	  public WebElement allDelete() { int i=0; List<WebElement> r= deleteAll;
	  for(WebElement a:deleteAll) { i++; } return deleteAll.get(1); }
	 
	public void alertClick() {
		alert.click();
	}
	public void DeleteExpenseMethod()
	{
		deleteExpense.click();
	}
	public void ExpenseMethod()
	{
		Expenses.click();
	}
	public String ExpenseText()
	{
		return expenseText.getText();
	}
	
	public void ButtonAdd()
	{
		AddExpenseButton.click();
	}
	public void ReferenceMethod(String text)
	{
		Reference.sendKeys(text);
	}
	public void CloseAddExpenceMethod()
	{
		closeAddExpence.click();
	}
	public void date(String string) {
		dateField.sendKeys(string);
		
	}
	public WebElement CategoryMethod()
	{
		return category;
	}
	
	public WebElement storeMethod()
	{
		return store;
	}
	public void AmountMethod(String amt)
	{
		amount.sendKeys(amt);
	}
	public WebElement AttachmentMethod()
	{
	return attachment;
	}
	public void SubmitMethod()
	{
		submit.click();
	}
	public void SearchMethodExpense(String expense)
	{
		searchExpense.sendKeys(expense);
	}
public String getResult() {
	return retrievedExpense.getText();
}

public SalesPage cancelMethod()

{
	cancel.click();
 return new SalesPage();
}
}
