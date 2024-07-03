package Keywords;


import UtilityLibrary.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ObjectRepository.LocatorRepository;

public class HomePage extends BaseClass{
	public String empty = "";
	
	public WebDriver driver;
	public LocatorRepository locate;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.locate = new LocatorRepository(this.driver);
	}
	
 
	public void signIn(String userEmail, String password) {
		driver.get("https://www.macys.com/");
		locate.home.acceptCookies.click();
		locate.home.closeTinyBox.click();
		locate.home.linkGiftRegistry.click();
		locate.home.signInLink.click();
		locate.signinPage.inputEmail.sendKeys(userEmail);
		locate.signinPage.inputPassword.sendKeys(password);
		locate.signinPage.btnSignIn.click();
		
	}
 
	public void navToTabs(String option) {
		dropdown(locate.home.listNavTabs, option);
	}
	
	

}
