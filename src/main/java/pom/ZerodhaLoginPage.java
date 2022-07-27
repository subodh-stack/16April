package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {
	
	@FindBy (xpath ="//input[@id='userid']")private WebElement userId;
	//private WebEleemnt userId =driver.findElement(By.xpath("//input[@id='userid"));
	@FindBy (xpath = "//input[@id='password']")private WebElement pass;
	@FindBy (xpath = "//button[@type='submit']")private WebElement submit;
	@FindBy (xpath = "//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp;
	@FindBy (xpath = "//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy (xpath ="//input[@id='pin']")private WebElement pin;
	@FindBy (xpath = "//button[@type='submit']")private WebElement ok;
	
	public ZerodhaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);//this method passes the driver to @FindBy annotation and ask it to find all the weblements
	}
	
	public void enterUserID(String user) {
		userId.sendKeys(user);
	}
	
	public void enterPassword(String password) {
		pass.sendKeys(password);
	}
	
	public void clickOnSubmit() {
		submit.click();
	}
	
	public void clickOnForgot() {
		forgot.click();
	}
	
	public void clickOnSignUp() {
		signUp.click();
	}

	public void enterPin(WebDriver driver,String pinNumber) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(3000));
		wait.pollingEvery(Duration.ofMillis(100));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(pinNumber);
	}
	
	public void clickOnContinue() {
		ok.click();
	}
	
}
