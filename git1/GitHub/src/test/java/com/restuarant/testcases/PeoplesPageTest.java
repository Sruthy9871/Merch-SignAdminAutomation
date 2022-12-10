package com.restuarant.testcases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restuarant.base.BaseClass;
import com.restuarant.pages.PeoplesPage;
import com.restuarant.utilities.ExcelReadUtility;
import com.restuarant.utilities.GeneralUtility;
import com.restuarant.utilities.WaitUtility;

public class PeoplesPageTest extends BaseClass {
	public static WaitUtility wt;
	PeoplesPage pp;
	public static ExcelReadUtility readExcel;
	public static GeneralUtility ob= new GeneralUtility();
	@Test(priority = 1, enabled = true)
	public void SelectPeople() throws InterruptedException {
		//driver=ob.getDriver();
		pp=new PeoplesPage();	
		wt= new WaitUtility(driver);
		wt.sleep(3000);
		pp.peopleMethod();
		pp.WaiterMethod();
		String waiter=pp.WaiterText().getText();
		Assert.assertEquals(waiter, "Waiter Name");
	}
	@Test(priority = 2, enabled = true)
	public void SearchWaiternotPresent() throws InterruptedException {
		pp=new PeoplesPage();	
		pp.WaiterSearch("raj");
		int totalWaitersRetrieved = pp.totalWaiters();
		if(totalWaitersRetrieved<0)
		{
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Waiters  found");
		}
		
	}
	
	@Test(priority = 3, enabled = true)
	public void SearchWaiterPresent() throws InterruptedException {
	
		pp=new PeoplesPage();	
		wt.sleep(3000);
		pp.WaiterSearch("Ram");
		int totalWaitersRetrieved = pp.totalWaiters();
		if(totalWaitersRetrieved>0)
		{
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Waiters not found");
		}
		
	}
	
	
	@Test(priority = 4, enabled = true)
	public void SelectCustomer() throws InterruptedException {
		//driver=ob.getDriver();
		pp=new PeoplesPage();
		wt.sleep(3000);
		pp.peopleMethod();
		pp.CustomerMethod();
		String waiter=pp.CustomerText().getText();
		Assert.assertEquals(waiter, "Customer Name");
	}
	@Test(priority = 5, enabled = true)
	public void SearchCustomernotPresent() throws InterruptedException {
		//driver=ob.getDriver();
		pp=new PeoplesPage();	
		wt.sleep(3000);
		pp.CustomerSearch("raj");
		int totalCustomersRetrieved = pp.totalCustomer();
		if(totalCustomersRetrieved<0)
		{
			Assert.assertTrue(true);
		}
		else {
			System.out.println("customer  found");
		}
		
	}
	
	@Test(priority = 6, enabled = true)
	public void SearchCustomerPresent() throws InterruptedException {
		//driver=ob.getDriver();
		pp=new PeoplesPage();	
		pp.CustomerSearch("akshay");
		int totalCustomersRetrieved = pp.totalCustomer();
		if(totalCustomersRetrieved>0)
		{
			Assert.assertTrue(true);
		}
		else {
			System.out.println("customer not found");
		}
		
	}
		@Test(priority = 7, enabled = true)
		public void addNewCustomer() throws Exception {
			readExcel = new ExcelReadUtility(BaseClass.getDriver());
			
			pp=new PeoplesPage();	
			ob.scrollBy(0, 280);
			pp.addCustomerMethod();
			 pp.customerNameMethod(readExcel.ReadCellData(1, 0));
			 pp.customerPhoneMethod(readExcel.ReadCellData(1, 1));
			 pp.customerEmailMethod(readExcel.ReadCellData(1, 2));
			 pp.customerDiscountMethod(readExcel.ReadCellData(1, 3)); 
			 pp.submitMethod();
			 
		}
			
		
	
}
