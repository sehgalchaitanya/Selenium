package web.tests.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	// Locate the logo element
    @FindBy(xpath = "//img[@class='logo-icon cmp-image__image' and @alt='KP Logo']")
    public WebElement kpLogo;
 
    //Locate the No button on the Feedback Banner (if any)
    @FindBy(xpath = "//button[contains(@aria-label, 'No: Do not take this survey. Closes this pop-up.')]")
    public WebElement noButtonOnFeedbackBanner;
    
    @FindBy(xpath = "//a[@class='kp-header-global-menu__menu-item__link' and @id='nav-0-menu-item-link-2' and @role='button']")
    public WebElement menuOption_Appt_Care;
    
    @FindBy(xpath = "//a[@id='get-care-linksmegamenucol1-appointments1' and @data-analytics-location='kp-header-meganav-secondary link']")
    public WebElement scheduleAnAppointmentLink;
    
    @FindBy (xpath = "//button[@class='button js' and @data-analytics-click='Schedule medical appointment' and @data-analytics-type='button']")
    public WebElement scheduleMedicalAppointmentButton;
    
    public void clickNoButtonOnFeedbackBanner() {
    // Click on the "No" button
    noButtonOnFeedbackBanner.click();
    }
    
    public void clickMenuOption_Appt_Care() {
    // Click on the "No" button
    menuOption_Appt_Care.click();
    }
    
    public void clickScheduleAnAppointmentLink() {
    	scheduleAnAppointmentLink.click();
    }
    
    public void clickscheduleMedicalAppointmentButton() {
    	scheduleMedicalAppointmentButton.click();
    }
 }
