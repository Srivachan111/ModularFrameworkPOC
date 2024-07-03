package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	WebDriver driver;
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//ul[@id=\"nav-top-menu\"]/li")
	public List<WebElement> listNavTabs; 
	
	@FindBy(xpath = "(//a[normalize-space()=\"Gift Registry\"])[1]")
	public WebElement linkGiftRegistry;
	
	@FindBy(xpath = "//a[@href=\"https://www.macys.com/myaccount/home\"]")
	public WebElement userProfile;
	
	@FindBy(xpath = "//a[@data-testid=\"signInLink\"]")
	public WebElement signInLink;
	
	@FindBy(xpath = "//button[@id=\"onetrust-accept-btn-handler\"]")
	public WebElement acceptCookies;
	
	@FindBy(xpath = "//a[@id=\"closeButton\"]")
	public WebElement closeTinyBox;
	
	
	

}