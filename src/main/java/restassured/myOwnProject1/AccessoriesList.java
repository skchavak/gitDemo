package restassured.myOwnProject1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AccessoriesList {
	WebDriver driver;
	
	public AccessoriesList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBys(@FindBy(xpath="//*[@class='rf-serp-results-tiles']/section/div //h2/a"))
	private List<WebElement> list;
	
	public List<WebElement> getListaccess(){
		return list;
		
	}

}
