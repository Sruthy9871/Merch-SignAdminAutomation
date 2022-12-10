package com.restuarant.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restuarant.base.BaseClass;
import com.restuarant.pages.SalesPage;

//import com.base.Pages.SalesPage;

public class SalesPageTest extends BaseClass{
	SalesPage sp;
	 @Test
	  public void SalesSearch() {
		 // driver= ob.getDriver();
		  sp= new SalesPage();
	      sp.SalesMethod();
	      String text= sp.SalesText();
	      Assert.assertEquals(text,"Sales");
	  
	  }
}
