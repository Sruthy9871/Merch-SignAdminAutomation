package com.restuarant.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.restuarant.base.BaseClass;
import com.restuarant.pages.ExpensePage;
import com.restuarant.utilities.GeneralUtility;
import com.restuarant.utilities.WaitUtility;

public class ExpensePageTest extends BaseClass {
	public static GeneralUtility ob = new GeneralUtility();
	public WebDriver driver;
	ExpensePage ep;
	WaitUtility wt;
	SoftAssert sf = new SoftAssert();

	@Test(priority = 0, enabled = true)
	public void ExpenseSearch() throws IOException {
		driver = GeneralUtility.getDriver();
		wt = new WaitUtility(driver);
		ep = new ExpensePage(driver);
		ep.ExpenseMethod();
		wt.sleep(6000);
		String text = ep.ExpenseText();
		ob.screenshots("ExpenseSearch");
		Assert.assertEquals(text, "Expence");
	}

	@Test(priority = 1, enabled = true)
	public void addExpence() throws Exception {

		ob.scrollBy(0, 280);
		ep.ButtonAdd();
		ep.date("12/11/2022");
		ep.ReferenceMethod("reference");
		WebElement category = ep.CategoryMethod();
		wt.waitForElementTobeVisible(driver, category, Duration.ofSeconds(60));
		ob.SelectByVisibleTextmethod(category, "Water");
		WebElement store = ep.storeMethod();
		ob.SelectByVisibleTextmethod(store, "AKStores");
		ep.AmountMethod("50");
		WebElement element = ep.AttachmentMethod();
		ob.uploadfileSendK(element, "C:\\Users\\user\\Pictures\\New Microsoft Office Word Document.docx");
		ob.scrollBy(0, 120);
		ob.screenshots("AddExpence");
		ep.SubmitMethod();
		String text = ep.ExpenseText();
		Assert.assertEquals(text, "Expence");
		// ep.CloseAddExpenceMethod();
	}

	@Test(priority = 2, enabled = true)
	public void searchExpence() throws Exception {
		// ep.SearchMethodExpense("reference");
		String result = ep.getResult();
		if (result.contains("reference")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3, enabled = true)
	public void deleteExpence() throws Exception {
		// ep.SearchMethodExpense("reference");
		wt.sleep(6000);
		// String result = ep.getResult();
		WebElement element = ep.allDelete();
		wt.waitForElementTobeVisible(driver, element, Duration.ofSeconds(6000));
		element.click();
		ep.ButtonConfirm();
		wt.sleep(6000);
		String url = driver.getCurrentUrl();
		sf.assertEquals(url, "https://qalegend.com/restaurant/expences", "Data deleted Successfully");
		wt.sleep(6000);
		// ep.ButtonConfirm();
		sf.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void deleteExpenceCancel() throws Exception {
		// ep.SearchMethodExpense("reference");
		wt.sleep(6000);
		// String result = ep.getResult();
		WebElement element = ep.allDelete();
		wt.waitForElementTobeVisible(driver, element, Duration.ofSeconds(6000));
		element.click();
		ep.cancelMethod();
		wt.sleep(6000);
		String url = driver.getCurrentUrl();
		sf.assertEquals(url, "https://qalegend.com/restaurant/expences", "Data deleted Successfully");
		wt.sleep(6000);
		// ep.ButtonConfirm();
		sf.assertAll();
	}

}
