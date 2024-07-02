package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_Page {
	public WebDriver driver;
	@FindBy(xpath = "//input[@id='email']")
	public WebElement inputEmail;
	
	@FindBy(xpath = "//input[@id=\"pw-input\"]")
	public WebElement inputPassword;
	
	@FindBy(xpath= "//button[@id=\"sign-in\"]")
	public WebElement btnSignIn;
	
	public SignIn_Page(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}	
	
}
