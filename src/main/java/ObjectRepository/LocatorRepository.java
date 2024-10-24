package ObjectRepository;

import org.openqa.selenium.WebDriver;

public class LocatorRepository {
public WebDriver driver;
public Login_Page loginPage;// = new Login_Page(driver);
public Home_Page home;// = new Home_Page(driver);
public Candidate_Page candidatePage;// = new Candidate_Page(driver);
public Roles_Page rolespage;// = new Roles_Page(driver);
public LocatorRepository (WebDriver driver) {
	this.driver = driver;
	
	loginPage = new Login_Page(driver);
	home = new Home_Page(driver);
	candidatePage = new Candidate_Page(driver);
	rolespage = new Roles_Page(driver);
}

}
