package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Men_Page {
	WebDriver driver;
	

	public Men_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}