package web.tests.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontDoor {
	
	WebDriver driver;
        
	    //Constructor to initialize the driver and elements on this page
		public FrontDoor(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//Identify the signInButton WebElement
		@FindBy(xpath = "//span[normalize-space()='Sign In']")
		public WebElement signInButton;
		
		@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
		public WebElement acceptAllButton;
		
		//Click on signInButton
		
		public void clickSignInButton() {
			signInButton.click();
		}
		
		public void clickAcceptAllButton() {
			acceptAllButton.click();
		}

	

}
