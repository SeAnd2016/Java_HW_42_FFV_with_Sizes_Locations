package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.JavascriptExecutor;

public class HtmlUnit {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		// Disable the logs
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String url = "http://facebook.com/";

		//driver = new HtmlUnitDriver();
		
		//WebDriver driver = new HtmlUnitDriver();
		//((HtmlUnitDriver) driver).setJavaScriptEnabled(true); //JavaScript Enable
		
		driver.get(url);
		
		System.out.println((String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"));
		System.out.println("Page URL: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		
		driver.quit();
	}

}
