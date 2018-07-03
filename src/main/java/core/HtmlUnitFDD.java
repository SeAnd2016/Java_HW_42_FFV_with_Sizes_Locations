package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitFDD {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
			
			// Disable the logs
			Logger logger = Logger.getLogger("");
			logger.setLevel(Level.OFF);
			
			String url1 = "http://alex.academy/exe/signup/v1/index.php";
			
			//String url1 = "https://www.facebook.com/";
			
			driver = new HtmlUnitDriver();
			((HtmlUnitDriver) driver).setJavascriptEnabled(true);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.get(url1);
			System.out.println("User Agent: "+ (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"));

			System.out.println("Browser:\tHtmlUnit");
			driver.quit();
			
		}
		
	}
