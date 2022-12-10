/**
 * 
 */
package com.restuarant.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.restuarant.pages.LoginPage;
import com.restuarant.utilities.GeneralUtility;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public LoginPage loginPage;
	GeneralUtility ul;

	public static void testBasic() throws IOException {
		try {
			prop = new Properties();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		FileInputStream fileIO = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
		try {
			prop.load(fileIO);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

	@Parameters("Browser")
	@BeforeTest(alwaysRun = true)
	public void beforemethod(String browser) throws IOException {
		if (browser.equals("chrome")) {

			testBasic();
			System.setProperty(prop.getProperty("chromeBrowserDriver"),
					System.getProperty("user.dir") + prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			loginPage = new LoginPage();
		}

		else if (browser.equals("firefox")) {
			testBasic();
			System.setProperty(prop.getProperty("fireFoxBrowserDriver"),
					System.getProperty("user.dir") + prop.getProperty("fireFoxBrowserDriverPath"));

			driver = new FirefoxDriver();
			loginPage = new LoginPage();
		} else {
			testBasic();
			System.setProperty(prop.getProperty("edgeBrowserDriver"),
					System.getProperty("user.dir") + prop.getProperty("edgeDriverPath"));

			driver = new EdgeDriver();
			loginPage = new LoginPage();

		}
		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void closebrowser() { 
		driver.close();

	}

	public static WebDriver getDriver() {

		return driver;
	}

	@AfterMethod
	public void aftermethod(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ul = new GeneralUtility();
			ul.screenshots("fail");
			// .Screenshotcapturefunc(driver, iTestResult.getName());

		}

	}
}
