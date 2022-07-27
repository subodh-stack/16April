package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public static void takeScreenShot(WebDriver driver, String name) throws IOException {
		String date =getDate();
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\91877\\OneDrive\\Documents\\MayBatch\\Screenshots\\"+name+""+date+".png");
		
		FileHandler.copy(source, destination);
	}
	
	public static String getDate() {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss"); //format the time date and time as required 
		  LocalDateTime currentTime = LocalDateTime.now();//return current time  
		  String d= dtf.format(currentTime); //format the time given my now()method to required format and return String
		  return d;
}
}
