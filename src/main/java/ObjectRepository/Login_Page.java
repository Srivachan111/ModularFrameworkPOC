package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Enter User ID or Registered Email ']")
	public WebElement inputUserName;
	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	public WebElement inputPassword;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement buttonSubmit;
	@FindBy(xpath= "//a[text()='Forgot Password?']")
	public WebElement buttonForgotPassword;
	
	
	public Login_Page(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}	
	
}
