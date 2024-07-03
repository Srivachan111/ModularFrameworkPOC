package ObjectRepository;

import org.openqa.selenium.WebDriver;

public class LocatorRepository {
	public WebDriver driver;

	public SignIn_Page signinPage;
	public Home_Page home;
	public Men_Page menPage;
	public Shirts_Page shirtsPage;
	public TShirts_Page tShirtPage;
	public Wishlist_Page wishlistPage;
	public CreateAccount_Page createAccountPage;
	public YourBag_Page yourBagPage;

	public LocatorRepository (WebDriver driver) {
		this.driver = driver;
		signinPage = new SignIn_Page(driver);
		home = new Home_Page(driver);
		menPage = new Men_Page(driver);
		shirtsPage = new Shirts_Page(driver);
		tShirtPage = new TShirts_Page(driver);
		wishlistPage = new Wishlist_Page(driver);
		createAccountPage = new CreateAccount_Page(driver);
		yourBagPage = new YourBag_Page(driver);
	}

}
