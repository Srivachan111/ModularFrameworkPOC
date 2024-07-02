package Keywords;


import UtilityLibrary.BaseClass;

import org.openqa.selenium.WebDriver;

import ObjectRepository.LocatorRepository;

public class HomePage extends BaseClass{
	public String empty = "";
	
	public WebDriver driver = initDriver("Chrome");
	public LocatorRepository locate = new LocatorRepository(driver);
 
	public void login(String userEmail, String password) {
		locate.signinPage.inputEmail.sendKeys(userEmail);
		locate.signinPage.inputPassword.sendKeys(password);
		locate.signinPage.btnSignIn.click();
		
	}
 
	public void navToTabs(String option) {
		dropdown(locate.home.listNavTabs, option);
	}
	
	

}
