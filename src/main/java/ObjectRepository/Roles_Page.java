package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Roles_Page {
	WebDriver driver;
	@FindBy(xpath = "//button[@data-rt-role-addnew=' addnewrole']")
	public WebElement btnAddRoles;
	@FindBy(xpath = "//button[@data-rt-role-add='ContinuetoReview']")
	public WebElement btnContinueReview;
	@FindBy(xpath = "//button[@data-rt-role-view=' Generateprofile']")
	public WebElement btnGenerateProfile;
	@FindBy(xpath = "//em[text()='Choose Language']/parent::div[@role='combobox']")
	public WebElement drpCodingLanguage;
	@FindBy(xpath = "//em[text()='Choose one option']/parent::div[@role='combobox']")
	public WebElement drpExperience;
	@FindBy(xpath = "//div[@aria-label='Without label']")
	public WebElement drpJobDescription;
	@FindBy(xpath = "//div[@role='combobox' and text()='Masters']")
	public WebElement drpRequiredDegree;
	@FindBy(xpath = "//div[@role='combobox' and text()='Engineering / Development']")
	public WebElement drpRoleCategory;
	@FindBy(xpath = "//div[@role='combobox' and text()='Top 25%']")
	public WebElement drpSelectivity;
	@FindBy(xpath = "//textarea[@id='textAreaValue']")
	public WebElement inputInternalNote;
	@FindBy(xpath = "//textarea[@id='textAreaValuejob']")
	public WebElement inputJobDescription;
	@FindBy(xpath = "//input[@id='rolename']")
	public WebElement inputRoleTitle;
	@FindBy(xpath = "//ul/li[@role='option']")
	public WebElement listDropdownOptions;
	@FindBy(xpath = "//ul//li[@role='option']")
	public WebElement listJobDescriptions;
	
	public Roles_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
