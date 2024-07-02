package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Candidate_Page {
	WebDriver driver;
	@FindBy(xpath = "//button[@data-rt-role-addnew='addnewcandidate']")
	public WebElement btnAddCandidate;
	@FindBy(xpath = "//button[@data-rt-role-addnew='addnewcandidate']/following-sibling::button")
	public WebElement btnRefreshList;
	@FindBy(xpath = "//input[@placeholder='Search candidate']")
	public WebElement inputSearchCandidate;
	@FindBy(xpath = "//button[@data-rt-candidate-add='savecandidate']")
	public WebElement btnSaveCandidate;
	@FindBy(xpath = "//p[text()='Degree']/following-sibling::div//div[@role='combobox']")
	public WebElement drpDegree;
	@FindBy(xpath = "//input[@id='email']")
	public WebElement inputEmail;
	@FindBy(xpath = "//input[@id='givenName']")
	public WebElement inputFirstName;
	@FindBy(xpath = "//textarea[@id='textAreaValue']")
	public WebElement inputIntenalNotes;
	@FindBy(xpath = "//input[@id='jobTitle']")
	public WebElement inputJobTitle;
	@FindBy(xpath = "//input[@id='familyName']")
	public WebElement inputFamilyName;
	@FindBy(xpath = "//input[@id='familyName']")
	public WebElement inputLastName;
	@FindBy(xpath = "//input[@id='linkedInUrl']")
	public WebElement inputLinkedinProfile;
	@FindBy(xpath = "//input[@id='location']")
	public WebElement inputLocation;
	@FindBy(xpath = "//input[@id='phone']")
	public WebElement inputPhoneNumber;
	@FindBy(xpath = "//p[text()='Candidate Resume']/following-sibling::input[@type='file']")
	public WebElement inputResume;
	@FindBy(xpath = "//input[@id='year']")
	public WebElement inputYear;
	@FindBy(xpath = "//ul/li[@role='option' and @data-value]")
	public List<WebElement> listDegree;
	@FindBy(xpath = "//div[@role='presentation']//span[@class='invitemsg']")
	public WebElement txtToastMessage;

	public Candidate_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
