package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnit {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		// Disable the logs
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String url = "http://alex.academy/exe/signup/v1/index.php";

		driver = new HtmlUnitDriver();
		
		WebDriver driver = new HtmlUnitDriver();
		((HtmlUnitDriver) driver).setJavascriptEnabled(true); //JavaScript Enable
		
		driver.get(url);
		
		//System.out.println((String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"));
		System.out.println("Page URL: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		
		driver.quit();
	}

}
