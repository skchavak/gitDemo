package restassured.myOwnProject1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class PageHomePage {

	WebDriver driver;

	public PageHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBys(@FindBy(xpath = "//*[@id='ac-globalfooter']/div/nav/div/div/ul/li/a"))
	private List<WebElement> footerLinks;

	@FindBy(xpath = "//*[@class='ac-gn-list']/li[10]/a")
	private WebElement Accories;

	public List<WebElement> getFooterLink() {

		return footerLinks;
	}
	public WebElement getAceessories() {
		return Accories;
		
	
	
	}
}