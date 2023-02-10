package restassured.myOwnProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
	WebDriver driver;
	
	public AddProduct(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="add-to-cart")
	private WebElement addCart;
	
	public WebElement getAddcart() {
		return addCart;
		
	}
}
