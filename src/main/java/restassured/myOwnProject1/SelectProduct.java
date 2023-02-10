package restassured.myOwnProject1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SelectProduct {
	WebDriver driver;
	
	public SelectProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBys(@FindBy(xpath="//*[@class='rf-browser-list']/li"))
	private List<WebElement> productList;
	
	public List<WebElement> getProductList(){
		return productList;
		
	}
	
	
}
