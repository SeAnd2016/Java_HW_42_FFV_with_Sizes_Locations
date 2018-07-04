package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class HtmlUnit_UserAgentOverride {
	
	public static void main(String[] args) {
		
		// Disable the logs
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String url = "http://alex.academy/exe/signup/v1/index.php";
		
		WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		
		//WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
		//WebDriver driver = new HtmlUnitDriver(BrowserVersion.EDGE);
		//WebDriver driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
		
		((HtmlUnitDriver) driver).setJavascriptEnabled(true); //JavaScript Enable
		
		driver.get(url);
		
		System.out.println("User Agent:\t"+ (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"));
		System.out.println("Page URL:\t" + driver.getCurrentUrl());
		System.out.println("Page Title:\t" + driver.getTitle());
		
		driver.quit();
	}

}
