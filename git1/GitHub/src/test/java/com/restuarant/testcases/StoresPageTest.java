package com.restuarant.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.restuarant.base.BaseClass;
import com.restuarant.pages.StoresPage;
import com.restuarant.utilities.WaitUtility;

public class StoresPageTest extends BaseClass {

	StoresPage strObj;
	WaitUtility wt = new WaitUtility(driver);

	@Test(priority = 1, enabled = true)
	public void SelectStore() {
		
		strObj =new StoresPage();
		strObj.StoresPageMethod();
		strObj.SearchStore("AbcStore");
		String actual=strObj.textStores();
		Assert.assertEquals(actual, "Store Name", "Not Equal");
		wt.sleep(3000);

	}
	
	
	@Test(priority = 2, enabled = true)
	public void SearchStore() throws InterruptedException {
		
		strObj.searchStores("ABCD");
		int totalstoresRetrieved = strObj.totalStores();
		if(totalstoresRetrieved>0)
		{
			Assert.assertTrue(true);
		}
		else {
			System.out.println("No Stores found");
		}
		wt.sleep(3000);
		
		
	}
}
