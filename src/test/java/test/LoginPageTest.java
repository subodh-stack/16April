package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pojo.ChromeBrowser;
import pom.ZerodhaLoginPage;
import utility.Excel;
import utility.Reports;

@Listeners(Listener.class)
public class LoginPageTest extends BaseTest {
	ExtentReports extent;
	ExtentTest test;
	@BeforeTest
	public void configureReport() {
		extent = Reports.generateReports();
	}
	
	@BeforeMethod
	public void lunchBrowser() {
		 driver =ChromeBrowser.openBrowser();
	}
	
	
	@Test
	public void loginZerodhaTest() throws EncryptedDocumentException, IOException, InterruptedException {
		test =extent.createTest("loginZerodhaTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String title = driver.getTitle();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading ");
		String user =Excel.getData("Credentials", 0, 0);
		String pass = Excel.getData("Credentials", 1, 0);
		String pin = Excel.getData("Credentials", 2, 0);
		zerodhaLoginPage.enterUserID(user);
		zerodhaLoginPage.enterPassword(pass);
		zerodhaLoginPage.clickOnSubmit();
		zerodhaLoginPage.enterPin(driver,pin);
		zerodhaLoginPage.clickOnContinue();
		soft.assertAll();
	
	}
	
	@Test
	public void verifySignUpFeature() {
		test =extent.createTest("verifySignUpFeature");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignUp();
	}
	
	@Test
	public void zerodhaForgotPasswordFeatureTest() {
		test =extent.createTest("zerodhaForgotPasswordFeatureTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgot();
	}
	
	@AfterMethod
	public void postExcution(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName() );
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void publishReport() {
		extent.flush();
	}
	
}
