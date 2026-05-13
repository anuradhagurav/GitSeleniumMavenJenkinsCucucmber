package tests;
 
import java.io.IOException;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser_set_up.BrowserSetup;
import pages.GoogleSearch;
import utils.ReadExcel;
import utils.ReadProperties;
 
public class GoogleTestAutomation {
	WebDriver driver;
	ReadProperties rp;
	BrowserSetup bs = new BrowserSetup();
	
	@DataProvider(name = "test1")
	public Object[][] createData1() throws IOException{
		ReadExcel read = new ReadExcel();
		Object[][] data = read.readExcelData(".\\src\\main\\resources\\TestData.xlsx", "TestData");
		
		return data;
	}
	
	@BeforeMethod
	@Parameters("Browser")
	public void setup(@Optional ("chrome") String browser) throws IOException{
	
		driver = bs.setupBrowser(browser);
		
		rp  = new ReadProperties();
		
		driver.get(rp.ReadProperty(".\\src\\main\\resources\\config.properties", "url"));
	}
	

	
	@Test(dataProvider = "test1")
	public void testCase1(String keyword) {
		Assert.assertEquals(driver.getTitle(), "Practice Page");
        System.out.println(driver.getTitle());
		GoogleSearch searchPage = new GoogleSearch(driver);
		
		ReadExcel re = new ReadExcel();
	
		searchPage.enterKeyword(keyword);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
 
}