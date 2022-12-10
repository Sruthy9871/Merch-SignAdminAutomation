package com.restuarant.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
import com.restuarant.base.BaseClass;


public class GeneralUtility extends BaseClass{


	public GeneralUtility()
	{
		PageFactory.initElements(driver, this);
	}
	Select slct;
	
	public void scrollBy(int a, int b) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(" + a + ", " + b + ")");

	}
	
	public void AlertAcceptMethod()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void AlertDismissMethod()
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void SelectByvalueMethod(WebElement element, String value) {
		slct = new Select(element);
		slct.selectByValue(value);
	}

	public void SelectByVisibleTextmethod(WebElement element, String text) {
		slct = new Select(element);
		slct.selectByVisibleText(text);
		
	}

	public void SelectByindexMethod(WebElement element, int value) {
		slct = new Select(element);
		slct.selectByIndex(value);
	}

	public void screenshots(String name) throws IOException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmsss");
		String timestamp = sdf.format(d);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File path = new File("D:\\workspace-DemoProject\\DemoProject\\src\\test\\resources\\Screenshots" + " "+name
				+ " "+timestamp + ".png");
		Files.copy(screenshotFile, path);
		
	}

	public void iframes(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void uploadfileSendK(WebElement element,String path)
	 {
		 
		 element.sendKeys(path);
	 }
	   public void uploadFile() throws Exception
	  {   
			
		   StringSelection s = new StringSelection("C:\\Users\\user\\Pictures\\New Microsoft Office Word Document.docx");
		   /*
			 * = driver.findElement(By.xpath("//*[@id=\"ImageInput\"]")); = new
			 * StringSelection(
			 * "D:\\workspace-DemoProject\\Restuarant\\src\\main\\resources\\Testdata.xlsx")
			 * ;
			 */
    // Clipboard copy
   // Clipboard copy
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
    //identify element and click
   // uploadrobot.click();
   Thread.sleep(2000);
    // Robot object creation
    Robot r = new Robot();
    //pressing enter
    r.keyPress(KeyEvent.VK_ENTER);
    //releasing enter
    r.keyRelease(KeyEvent.VK_ENTER);
    //pressing ctrl+v
    r.keyPress(KeyEvent.VK_CONTROL);
    r.keyPress(KeyEvent.VK_V);
    //releasing ctrl+v
    r.keyRelease(KeyEvent.VK_CONTROL);
    r.keyRelease(KeyEvent.VK_V);
    //pressing enter
    r.keyPress(KeyEvent.VK_ENTER);
    //releasing enter
    r.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(6000); 
	  }
}
