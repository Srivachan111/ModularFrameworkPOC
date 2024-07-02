package TestCase;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DataFiles.DataParser;
import ObjectRepository.LocatorRepository;
import UtilityLibrary.BaseClass;

public class CreateAccount extends BaseClass {
	public WebDriver driver = initDriver("Chrome");
	public Map<Object, Object> loginData;
	public void dataFetcher() throws IOException {
	DataParser data = new DataParser("TechScoreData");
	this.loginData = data.dataSet("TechScoreData");
	}
	LocatorRepository locate = new LocatorRepository(driver);

	@Test
	public void loginTest() {
	}

}
