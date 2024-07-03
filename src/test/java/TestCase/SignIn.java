package TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Keywords.HomePage;
import ObjectRepository.LocatorRepository;
import UtilityLibrary.BaseClass;

public class SignIn extends BaseClass{
	public WebDriver driver = initDriver("Chrome");
	LocatorRepository locate = new LocatorRepository(driver);
	HomePage homepage = new HomePage(driver);

	
	
	
	@Test(description = "Verify user able to login succesfully")
	public void TS_02_TC_01() {
		homepage.signIn("satyam.choudhury007@gmail.com", "Test@123");
		Assert.assertTrue(locate.home.userProfile.isDisplayed());
		
	}
	
	
}
