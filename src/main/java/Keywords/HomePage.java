package Keywords;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ObjectRepository.LocatorRepository;
import UtilityLibrary.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends BaseClass {
	Logger getLogger;
	public WebDriver driver;
	public LocatorRepository locate;
	public HomePage(WebDriver driver, Logger logger){
		this.driver = driver;
		this.locate = new LocatorRepository(driver);
		this.getLogger = logger;
			
	}
	
	public Logger getLogger() {
		return getLogger;
	}

	public void login(String userName, String password) {
		getLogger().info(" : login()");
		locate.loginPage.inputUserName.sendKeys(userName);
		locate.loginPage.inputPassword.sendKeys(password);
		locate.loginPage.buttonSubmit.click();
		//locate.home.btnPersonalProfile.click();
	}

	public void navToTabs(String option) {
		dropdown(locate.home.listNavTabs, option);
	}

	public void logout() {
		getLogger().info(" : logout()");
		locate.home.btnPersonalProfile.click();
		dropdown(locate.home.listProfileOptions, "Logout");
	}

}
