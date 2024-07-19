package web.tests.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontDoorSignIn {
	
	WebDriver driver;
	
	public FrontDoorSignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//input[@id='userid' and @name='pf.username' and @type='text']")
	public WebElement userID;
	
	@FindBy(xpath = "//input[@id='rememberUsername']")
	public WebElement saveUserId;
	
	@FindBy(xpath = "//input[@id='password' and @name='pf.pass' and @type='password']")
	public WebElement password;
	
	@FindBy(xpath = "//button[@id='submitButton' and @name='signonButton' and @type='button']")
	public WebElement signInButton;
	
	
	//div[@id='notification-pattern__heading-auth-msg']/child::span
	
	@FindBy(xpath = "//div[@id='notification-pattern__heading-auth-msg']/child::span")
	public WebElement errorMessageElement;
	
	
	public void enterUsername(String user){
		userID.clear();
		userID.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickSignIn() {
		if (signInButton.isEnabled()) {
            // If the button is enabled, click it
			signInButton.click();
            System.out.println("SignInButton clicked successfully.");
        } else {
            System.out.println("SignInButton is not enabled.");
        }
	}
	
}
