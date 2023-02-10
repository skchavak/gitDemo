package resource;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSetup {
	WebDriver driver;
	String browser;
	public WebDriverWait wait;
	
	public DriverSetup (String browser) {
		this.browser = browser;
		
	}
	public WebDriver getDriverSetup() {
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions pref = new ChromeOptions();
//			pref.addExtensions(new File("C:\\Users\\saurabh\\Desktop\\Extensions\\Adblock-Plusfree-ad-blocker.crx"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}else {
			driver = new ChromeDriver();
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
}
