package ObjectRepository;

import org.openqa.selenium.WebDriver;

public class LocatorRepository {
	public WebDriver driver;
	public LocatorRepository (WebDriver driver) {
		this.driver = driver;
	}
	public SignIn_Page signinPage = new SignIn_Page(driver);
	public Home_Page home = new Home_Page(driver);
	public Men_Page menPage = new Men_Page(driver);
	public Shirts_Page shirtsPage = new Shirts_Page(driver);
	public TShirts_Page tShirtPage = new TShirts_Page(driver);
	public Wishlist_Page wishlistPage = new Wishlist_Page(driver);
	public CreateAccount_Page createAccountPage = new CreateAccount_Page(driver);
	public YourBag_Page yourBagPage = new YourBag_Page(driver);
}
