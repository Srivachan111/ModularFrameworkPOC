package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Wishlist_Page {
    WebDriver driver;
	
	
	public Wishlist_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
