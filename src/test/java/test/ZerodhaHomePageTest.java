package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.ChromeBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Excel;

public class ZerodhaHomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void loginToZerodha() throws InterruptedException, EncryptedDocumentException, IOException {
		driver =ChromeBrowser.openBrowser();
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userId =Excel.getData("Credentials", 0, 0);
		String pass =Excel.getData("Credentials", 1, 0);
		String pin = Excel.getData("Credentials", 2, 0);
		zerodhaLoginPage.enterUserID(userId);
		zerodhaLoginPage.enterPassword(pass);
		zerodhaLoginPage.clickOnSubmit();
		Thread.sleep(1000);
		zerodhaLoginPage.enterPin(driver,pin);
		zerodhaLoginPage.clickOnContinue();
	}
	
	@Test
	public void searchStockAndClickOnBuy() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock(driver,"Tata");
		zerodhaHomePage.selectStockFromSearchList(driver, "TATAMOTORS");
	}
	
	@Test
	public void searchStock() {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock(driver,"");
		int size =zerodhaHomePage.getSearchListSize();
		Assert.assertTrue(size > 0);//Hard assert will stop the execution
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
	//	driver.close();
		
	}
	
}
