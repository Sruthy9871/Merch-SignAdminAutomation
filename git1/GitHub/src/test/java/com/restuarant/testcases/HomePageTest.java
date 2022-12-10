package com.restuarant.testcases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.restuarant.base.BaseClass;
import com.restuarant.pages.HomePage;
import com.restuarant.pages.ProductsPage;
import com.restuarant.utilities.WaitUtility;

public class HomePageTest extends BaseClass{
	ProductsPage prdctObj;
	HomePage hp;
	WaitUtility wt= new WaitUtility(driver);
	
	/*
	 * @Test(priority=1) public void selectLanguage() { hp = new HomePage();
	 * hp.seleclLanguage();
	 * 
	 * }
	 */
	SoftAssert sf= new SoftAssert();
  @Test(priority=0, enabled= true)
  public void language() {
	  hp = new HomePage();
	  hp.drpdwn();
	  wt.sleep(3000);
	  hp.Greek();
		String actual1 = hp.categories();
		sf.assertEquals(actual1, "ΚΑΤΗΓΟΡΊΕΣ");
		sf.assertAll();
  }
  
  @Test(priority = 1, enabled = true)
	public void SelectLangEnglish() throws InterruptedException {
		
		WebElement element= hp.lang();
		wt.waitForElemntTobeClickable(driver, element, Duration.ofSeconds(30));
		hp.drpdwn();
		hp.english();
		 wt.sleep(3000);
		String actual = hp.categories();
		sf.assertEquals(actual, "CATEGORIES");
		sf.assertAll();
}
	  
	  @Test(priority=2, enabled= true)
	  public void products() {
	  hp = new HomePage();
	  String url="https://qalegend.com/restaurant/products";
	  prdctObj= hp.product();
	  wt.sleep(3000);
	  String actUrl=driver.getCurrentUrl();
	  Assert.assertEquals(actUrl, url);
  }
}
