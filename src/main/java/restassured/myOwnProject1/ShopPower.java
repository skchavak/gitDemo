package restassured.myOwnProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPower {
	WebDriver driver;
	
	public ShopPower(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
  @FindBy(xpath="//*[text()='Shop Power & Cables']")
  private WebElement shoppower;
  
  public WebElement getShopPower() {
	return shoppower;
	  
  }
}
