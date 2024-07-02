package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	WebDriver driver;
	@FindBy(xpath = "//button[@aria-label='account of current user']")
	public WebElement btnPersonalProfile;
	@FindBy(xpath = "//a[contains(@href,'/')]//p")
	public List<WebElement> listNavTabs;
	@FindBy(xpath = "//ul//li[@role='menuitem']")
	public List<WebElement> listProfileOptions;
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}