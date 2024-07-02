package Keywords;

import org.openqa.selenium.WebDriver;

import ObjectRepository.LocatorRepository;
import UtilityLibrary.BaseClass;

public class HomePage extends BaseClass {

	public WebDriver driver = initDriver("Chrome");
	public LocatorRepository locate = new LocatorRepository(driver);

	public void login(String userName, String password) {
		locate.loginPage.inputPassword.sendKeys(userName);
		locate.loginPage.inputPassword.sendKeys(password);
		locate.loginPage.buttonSubmit.click();
		locate.home.btnPersonalProfile.click();
	}

	public void navToTabs(String option) {
		dropdown(locate.home.listNavTabs, option);
	}

	public void logout() {
		locate.home.btnPersonalProfile.click();
		dropdown(locate.home.listProfileOptions, "Logout");
	}

}
