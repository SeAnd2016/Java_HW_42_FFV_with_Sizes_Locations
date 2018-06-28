package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chrome {
	
	static WebDriver driver;
	By by;
	
	public static boolean isPresent(final By by) {
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty()) return true;
		else return false;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		// Disable the logs
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String driverPath = "";
		
		String url = "http://facebook.com/";
		
		// We are checking, which system we are using for test execution
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/chromedriver";

        else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) // If we have WebDrivers for PC
            driverPath = "./resources/webdrivers/pc/chromedriver.exe";

        else 
	        throw new IllegalArgumentException("Unknown OS. Script should be executed on Mac");
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		// Disable debugging logs
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		
		// Disable infobars and notifications
		option.addArguments("disable-infobars")	;
		option.addArguments("--disable-notifications");
		
		// Maximaze browser window
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			option.addArguments("-start-fullscreen");
		    
			//Custom size
			//driver.manage().window().setSize(new Dimension(400, 600));
			//option.addArguments("--window-size=1000,800"); //For Google Chrome
		
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) // If we have WebDrivers for PC
		    option.addArguments("--start-maximized"); 
		
		driver = new ChromeDriver(option);
		
		WebDriverWait wait15 = new WebDriverWait(driver, 15);
		WebDriverWait wait30 = new WebDriverWait(driver, 30);
		
		// Default browser windows size
		Dimension windowSize = driver.manage().window().getSize();
		System.out.println("01. Windows size: " + windowSize);
		
		//Web Framework Benchmarks
		final long start = System.currentTimeMillis();
		
		driver.get(url);
		
		// driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait15.until(ExpectedConditions.titleIs("Facebook - Log In or Sign Up"));
        wait15.until(ExpectedConditions.titleContains("Log In"));
        String title = driver.getTitle();
        // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
		System.out.println("02. Browser is: Chrome");
		System.out.println("03. Title of the page: " + title);
        
		String copyrightString = wait15.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pageFooter\"]/div[3]/div/span"))).getText();
		By copyright = By.xpath("//*[@id=\"pageFooter\"]/div[3]/div/span");
		System.out.println("04. Element [Copyright Text]: \"" + copyrightString + "\" " + (isPresent(copyright) ? "Exists" : "Not exists"));
        System.out.println("05. Size of [Copyright Text]: \"" + copyrightString + "\" " + (Dimension) driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/div[3]/div/span")).getSize());
        System.out.println("06. Location of [Copyright Text]: \"" + copyrightString + "\" " + (Point) driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/div[3]/div/span")).getLocation());
        
        // Log In
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).clear();
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("*******");
        By email = By.id("email");
		System.out.println("07. Element [Email Field]: " + (isPresent(email) ? "Exists" : "Not exists"));
        System.out.println("08. Size of [Email Field]: " + (Dimension) driver.findElement(By.id("email")).getSize());
        System.out.println("09. Location of [Email Field]: " + (Point) driver.findElement(By.id("email")).getLocation());
        
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).clear();
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys("*******");
        By pass = By.id("pass");
		System.out.println("10. Element [Password Field]: " + (isPresent(email) ? "Exists" : "Not exists"));
        System.out.println("11. Size of [Password Field]: " + (Dimension) driver.findElement(By.id("pass")).getSize());
        System.out.println("12. Location of [Password Field]: " + (Point) driver.findElement(By.id("pass")).getLocation());
        
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"loginbutton\"]/input"))); 
        By loginButton = By.xpath("//*[@id=\"loginbutton\"]/input");
		System.out.println("13. Element [Login Button]: " + (isPresent(loginButton) ? "Exists" : "Not exists"));
        System.out.println("14. Size of [Login Button]: " + (Dimension) driver.findElement(By.xpath("//*[@id=\"loginbutton\"]/input")).getSize());
        System.out.println("15. Location of [Login Button]: " + (Point) driver.findElement(By.xpath("//*[@id=\"loginbutton\"]/input")).getLocation());
        wait15.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginbutton\"]/input"))).click(); 
        
        // Find friends
        wait15.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span"))); 
        By timelineButton = By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span");
		System.out.println("16. Element [Timeline Button]: " + (isPresent(timelineButton) ? "Exists" : "Not exists"));
        System.out.println("17. Size of [Timeline Button]: " + (Dimension) driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).getSize());
        System.out.println("18. Location of [Timeline Button]: " + (Point) driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).getLocation());
        wait30.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span"))).click();
        
        String friends = wait30.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"_gs6\"]"))).getText();
        By friendsButton = By.xpath("//span[@class=\"_gs6\"]");
		System.out.println("19. Element [Friends Button]: " + (isPresent(friendsButton) ? "Exists" : "Not exists"));
        System.out.println("20. Size of [Friends Button]: " + (Dimension) driver.findElement(By.xpath("//span[@class=\"_gs6\"]")).getSize());
        System.out.println("21. Location of [Friends Button]: " + (Point) driver.findElement(By.xpath("//span[@class=\"_gs6\"]")).getLocation());
        
        wait30.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"logoutMenu\"]/a[1]"))); 
        By accountSettings = By.xpath("//div[@id=\"logoutMenu\"]/a[1]");
		System.out.println("22. Element [Account Settings]: " + (isPresent(accountSettings) ? "Exists" : "Not exists"));
        System.out.println("23. Size of [Account Settings]: " + (Dimension) driver.findElement(By.xpath("//div[@id=\"logoutMenu\"]/a[1]")).getSize());
        System.out.println("24. Location of [Account Settings]: " + (Point) driver.findElement(By.xpath("//div[@id=\"logoutMenu\"]/a[1]")).getLocation());
        wait30.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"logoutMenu\"]/a[1]"))).click();   
        
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        By logoutButton = By.xpath("//span[@class=\"_54nh\"][text()=\"Log Out\"]");
		System.out.println("25. Element [Log Out Button]: " + (isPresent(logoutButton) ? "Exists" : "Not exists"));
        System.out.println("26. Size of [Log Out Button]: " + (Dimension) driver.findElement(By.xpath("//span[@class=\"_54nh\"][text()=\"Log Out\"]")).getSize());
        System.out.println("27. Location of [Log Out Button]: " + (Point) driver.findElement(By.xpath("//span[@class=\"_54nh\"][text()=\"Log Out\"]")).getLocation());
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement logout = wait15.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"_54nh\"][text()=\"Log Out\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
        
		driver.quit();
		
		//Web Framework Benchmarks
		final long finish = System.currentTimeMillis();

		System.out.println("---------------------------------");
		System.out.println("28. Copyright: " + copyrightString);
		System.out.println("29. You have " + friends + " friends");
		System.out.println("30. Response time: " + (finish - start)/1000 + " sec");
	}
} 

