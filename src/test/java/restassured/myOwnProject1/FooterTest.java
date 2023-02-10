package restassured.myOwnProject1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import resource.DriverSetup;

public class FooterTest {
	WebDriver driver;
	DriverSetup setup;
	WebDriverWait wait;

	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void beforeClass(@Optional("chrome") String browser, ITestContext context) {
		setup = new DriverSetup(browser);
		driver = setup.getDriverSetup();
		wait = setup.wait;
		context.setAttribute("WebDriver", driver);
	}

	@Test(enabled = true, groups = "Method1")
	public void FooterLink() throws MalformedURLException, IOException {

		driver.get("https://www.apple.com/in/?cid-oas-in-domains-apple.in/");
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		

		PageHomePage php = new PageHomePage(driver);
		for (WebElement e : php.getFooterLink()) {
			String newtab= Keys.chord(Keys.CONTROL,Keys.ENTER);
			String firsthandle = driver.getWindowHandle();
			e.sendKeys(newtab);
			for(String winhaldle:driver.getWindowHandles()) {
				driver.switchTo().window(winhaldle);
			}
			driver.close();
			driver.switchTo().window(firsthandle);
			int respcode = 0;
			String url = "";
			try {
				url = e.getAttribute("href");
				HttpURLConnection x = (HttpURLConnection) new URL(url).openConnection();
				x.setRequestMethod("HEAD");
				x.connect();
				respcode = x.getResponseCode();
				System.out.println(e.getText() + " : " + respcode);

			} catch (Exception ex) {
				System.out.println(e.getText() + "  BROKEN LINK  " + respcode);
				System.out.println(url);

			}

		}
	}
	
	@Test(groups = "Method2")
	public void addCart() {
		driver.get("https://www.apple.com/in/");
		String[] product= {"Battery Pack","iphone Lightning Dock"};
		PageHomePage php = new PageHomePage(driver);
		php.getAceessories().click();
		//Assert.assertTrue(false);
		SelectProduct sp = new SelectProduct(driver);
		for(WebElement e: sp.getProductList()) {
			String title = e.getText().toLowerCase();
			if(title.contains("iphone")) {
				e.click();
				break;
			}
		}
		ShopPower sip = new ShopPower(driver);
		wait.until(ExpectedConditions.visibilityOf(sip.getShopPower()));
		Actions act = new Actions(driver);
		act.scrollToElement(sip.getShopPower()).moveToElement(sip.getShopPower()).click().perform();
		
		AccessoriesList al = new AccessoriesList(driver);
		for(WebElement e: al.getListaccess()) {
			String product1 = e.getText().toLowerCase();
			for(int i=0;i<product.length;i++) {
				if(product1.contains(product[i].toLowerCase())) {
					String firstHandle = driver.getWindowHandle();
					String ProductLink = e.getAttribute("href");
					wait.until(ExpectedConditions.visibilityOf(e));
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(ProductLink);
					
					AddProduct ap = new AddProduct(driver);
					ap.getAddcart().click();
					driver.close();
					driver.switchTo().window(firstHandle);
					
				} 
			}
		}
		
		
	}

}
