package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Screenshot;

public class Listener extends BaseTest implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test has started "+ result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testpassed "+ result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		try {
			Screenshot.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped "+ result.getName());
	}
	
}
