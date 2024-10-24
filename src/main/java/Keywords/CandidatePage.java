package Keywords;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ObjectRepository.LocatorRepository;
import UtilityLibrary.BaseClass;

public class CandidatePage extends BaseClass{
    Logger getLogger;
	public WebDriver driver;
	public LocatorRepository locate;
	public CandidatePage(WebDriver driver, Logger logger){
		this.driver = driver;
		this.locate = new LocatorRepository(driver);
		this.getLogger = logger;
	}
	
	public Logger getLogger() {
		return getLogger;
	}
	public String empty = "";
	
	public void addCandidate(Map<String,String> candidateData) {
		getLogger().info(" : addCandidate()");
		locate.candidatePage.btnAddCandidate.click();
		locate.candidatePage.inputLinkedinProfile.sendKeys(candidateData.get("LinkedProfile"));
		locate.candidatePage.inputFirstName.sendKeys(candidateData.get("FirstName"));
		locate.candidatePage.inputLastName.sendKeys( candidateData.get("LastName"));
		locate.candidatePage.inputPhoneNumber.sendKeys(candidateData.get("PhoneNumber"));
		locate.candidatePage.inputEmail.sendKeys(candidateData.get("EmailAddress"));
		locate.candidatePage.inputJobTitle.sendKeys(candidateData.get("JobTitle"));
		locate.candidatePage.drpDegree.click();
		dropdown(locate.candidatePage.listDegree,candidateData.get("Degree"));
		locate.candidatePage.inputYear.sendKeys(candidateData.get("Experience"));
		locate.candidatePage.inputLocation.sendKeys(candidateData.get("Location"));
		if(candidateData.get("InternalNotes") != empty) {
			locate.candidatePage.inputIntenalNotes.sendKeys(candidateData.get("InternalNotes"));
		}
		locate.candidatePage.btnSaveCandidate.click();
	}

}
