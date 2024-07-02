package Keywords;

import java.util.Map;

public class Candidates extends HomePage{
	public String empty = "";
	
	public void addCandidate(Map<Object,String> candidateData) {
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
