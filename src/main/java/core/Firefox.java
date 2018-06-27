package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firefox {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		// Disable the logs
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String driverPath = "";
		
		String url = "http://facebook.com/";
		
		// We are checking, which system we are using for test execution
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/geckodriver.sh";

        else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) // If we have WebDrivers for PC
            driverPath = "./resources/webdrivers/pc/geckodriver.exe";

        else 
	        throw new IllegalArgumentException("Unknown OS. Script should be executed on Mac");
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		// Disable notifications
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("dom.webnotifications.enabled", false);
		
		// Firefox on foreground
		options.addArguments("-foreground"); 
		
		driver = new FirefoxDriver(options);

		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebDriverWait wait15 = new WebDriverWait(driver, 15);
		WebDriverWait wait30 = new WebDriverWait(driver, 30);

        driver.get(url);
        // driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait15.until(ExpectedConditions.titleIs("Facebook - Log In or Sign Up"));
        wait15.until(ExpectedConditions.titleContains("Log In"));
        String title = driver.getTitle();
        // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        		.withTimeout(15, TimeUnit.SECONDS)
        		.pollingEvery(5, TimeUnit.SECONDS)
        		.ignoring(NoSuchElementException.class);
        String copyright = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pageFooter\"]/div[3]/div/span"))).getText();
        
        // Log In
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).clear();
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("email");
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).clear();
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys("***");
        wait15.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginbutton\"]/input"))).click();       
        
        // Find friends
        wait30.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span"))).click();             
        String friends = wait30.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"_gs6\"]"))).getText();
        wait30.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"logoutMenu\"]/a[1]"))).click();   
        
        WebElement logout = wait15.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"_54nh\"][text()=\"Log Out\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
        
		driver.quit();
		
		System.out.println("Browser is: Firefox");
		System.out.println("Title of the page: " + title);
		System.out.println("Copyright: " + copyright);
		System.out.println("You have " + friends + " friends");
		
	}
} 

