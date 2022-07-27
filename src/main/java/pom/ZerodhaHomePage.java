package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {
	@FindBy (xpath= "//input[@icon='search']")private WebElement search;
	@FindBy (xpath="//span[@class='tradingsymbol']")private List<WebElement> stock;
	@FindBy (xpath = "//button[@data-balloon='Buy']") private WebElement buy;
	
	public ZerodhaHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchStock(WebDriver driver,String stockName) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(stockName);
	}
	
	public void selectStockFromSearchList(WebDriver driver, String nameOfStock) {
		for(int i=0;i<stock.size();i++) {
			WebElement currentStock =stock.get(i);
			String name = currentStock.getText();
			if(name.equals(nameOfStock))
			{
				Actions actions = new Actions(driver);
				actions.moveToElement(currentStock);
				actions.perform();
				buy.click();
			}
		}
	}
	
	public int getSearchListSize() {
		int size =stock.size();
		return size;
	}


}
