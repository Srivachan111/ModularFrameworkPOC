package TestCase;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DataFiles.DataParser;
import Keywords.CandidatePage;
import Keywords.HomePage;
import ObjectRepository.LocatorRepository;
import ProjectSetup.BaseTest;
import UtilityLibrary.BaseClass;
import UtilityLibrary.SpreadSheetsUtils;


public class Candidates extends BaseTest {
	
	
	@Test
	public void addCandidate() throws IOException, InterruptedException {
		String filepath = System.getProperty("user.dir") + "\\Resources\\TestData\\TechScoreData.xlsx";
		SpreadSheetsUtils datafile = new SpreadSheetsUtils(filepath);
		Map<String,String> credential = datafile.getMapData("Credentials","cred1");
		Map<String,String> candidateData = datafile.getMapData("CandidateData", "TestUser3");
		WebDriver driver = getDriver();
    	LocatorRepository locate = new LocatorRepository(driver);
    	HomePage home = new HomePage(driver, getLogger());
    	CandidatePage cnd = new CandidatePage(driver,getLogger());
    	getLogger().info("Initialising driver");
    	driver.get(credential.get("URL"));
    	getLogger().info("launching the site");
		home.login(credential.get("UserEmail"), credential.get("UserPassword"));
		
		Thread.sleep(3000);
		cnd.addCandidate(candidateData);
	}
	
	
//	@Test
//	public void addCandidate() throws IOException, InterruptedException {
//		dataFetcher();
//		WebDriver driver = getDriver();
//    	LocatorRepository locate = new LocatorRepository(driver);
//    	HomePage home = new HomePage(driver, getLogger());
//    	CandidatePage cnd = new CandidatePage(driver,getLogger());
//    	driver.get("https://app.stage.yourtechscore.com/");
//		home.login("lbasidoni@bayonesolutions.com", "LakkappaB@18");
//		Thread.sleep(3000);
//		cnd.addCandidate(candidateData);
//	}
//	
	
	

}




//public WebDriver driver = initDriver("Chrome");
	//LocatorRepository locate = new LocatorRepository(driver);

//public Map<Object, String> candidateData;
//
//
//public void dataFetcher() throws IOException {
//DataParser data = new DataParser("TechScoreData");
//this.candidateData = data.dataSet("TechScoreData");
//}

