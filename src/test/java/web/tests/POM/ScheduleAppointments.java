package web.tests.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScheduleAppointments {
	
WebDriver driver;
	
	public ScheduleAppointments(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	// Locate the primaryIconPlus element in Schedule Appointments page
    @FindBy(xpath = "//button[@id='step-increment-self']//i[@class='icon-plus']")
    public WebElement primaryIconPlus;
    
    @FindBy(xpath = "//button[@id='btn-next']")
    public WebElement nextButtonInSheduleAppointmentPage;
    
    //Reason Illness Other Concerns radio button in Schedule Appointment page
    //div[@id='focusing-input-A01']//div[@class='selectable__checkmark']
    //div[@id='focusing-input-A01']//div[@class='selectable__checkmark-container']
    @FindBy(xpath = "(//div[@id='focusing-input-A01'])[1]")
    public WebElement radioIllnesOtherConcerns;
    
  //Another set of Reason radio buttons in Schedule Appointment page
    @FindBy(xpath = "//div[@id='focusing-input-B015']//div[@class='selectable__circle-radio']")
    public WebElement reasonReturnOrFollowUp;
    
    //Another set of radio buttons for Apoointment Type like In Person, Telephone or Video
    @FindBy(xpath = "//div[@id='focusing-input-B021']//div[@class='selectable__circle-radio']")
    public WebElement typeInPerson;
    
    //Facility Dropdown
    @FindBy(xpath = "//select[@id='select-menu-0']")
    public WebElement facilityDropdown;
    
  //Mandatory checkbox before continue scheduling appointment
    @FindBy(xpath = "//label[@id='label-B000']")
    public WebElement checkboxContinueSchedulingApt;
    
  // Web Elements specifically for Date Picker and Calendar
    
  //Radio button for First Available Date 
    @FindBy(xpath = "//div[@id='date-selectable-0']//div[@class='selectable__circle-radio']")
    public WebElement firstAvailableDate;
    
    //Radio Button for choose another date
    @FindBy(xpath = "//div[@id='date-cal-selectable-0']//div[@class='selectable__circle-radio']")
    public WebElement chooseAnotherDate;
    
    //Date Field that opens Calendar for choosing the Date
    @FindBy(xpath = "(//img[@class='datepicker-single-icon'])[1]")
    public WebElement datePicker;
    
    //Month from the calendar
    @FindBy(xpath = "//th[@class='month']")
    public WebElement calMonth;
    
    /* Select time slot for Appointment - First Available on the page */
    @FindBy(xpath = "//div[@id='focusing-input-00']//div[@class='selectable__circle-radio']")
    public WebElement selectTimeSlot;
    
    
    public void clickPrimaryIconPlus() {
		if (primaryIconPlus.isEnabled()) {
            // If the button is enabled, click it
			primaryIconPlus.click();
            System.out.println("primaryIconPlus clicked successfully.");
        } else {
            System.out.println("primaryIconPlus is not enabled.");
        }
	}

    public void clickNextButtonInSheduleAppointmentPage() {
		if (nextButtonInSheduleAppointmentPage.isEnabled()) {
            // If the button is enabled, click it
			nextButtonInSheduleAppointmentPage.click();
            System.out.println("nextButtonInSheduleAppointmentPage clicked successfully.");
        } else {
            System.out.println("nextButtonInSheduleAppointmentPage is not enabled.");
        }
	}
    
    public void clickOnFacilityDropdown() {
		if (facilityDropdown.isDisplayed()) {
            // If the button is enabled, click it
			facilityDropdown.click();
            System.out.println("facilityDropdown clicked successfully.");
        } else {
            System.out.println("facilityDropdown is not enabled or clickable.");
        }
	}
    
    public void clickOnRadioIllnesOtherConcerns() {
		if (radioIllnesOtherConcerns.isEnabled()) {
            // If the button is enabled, click it
			radioIllnesOtherConcerns.click();
            System.out.println("radioIllnesOtherConcerns clicked successfully.");
        } else {
            System.out.println("radioIllnesOtherConcerns is not enabled or clickable.");
        }
	}
    
    public void clickOncheckboxContinueSchedulingApt() {
		if (radioIllnesOtherConcerns.isEnabled()) {
            // If the button is enabled, click it
			checkboxContinueSchedulingApt.click();
            System.out.println("checkboxContinueSchedulingApt clicked successfully.");
        } else {
            System.out.println("checkboxContinueSchedulingApt is not enabled or clickable.");
        }
	}
    
    public void clickOnRadioReasonReturnOrFollowUp() {
		if (radioIllnesOtherConcerns.isEnabled()) {
            // If the button is enabled, click it
			reasonReturnOrFollowUp.click();
            System.out.println("reasonReturnOrFollowUp clicked successfully.");
        } else {
            System.out.println("reasonReturnOrFollowUp is not enabled or clickable.");
        }
	}
    
    public void clickOnRadioTypeInPerson() {
		if (radioIllnesOtherConcerns.isEnabled()) {
            // If the button is enabled, click it
			typeInPerson.click();
            System.out.println("typeInPerson clicked successfully.");
        } else {
            System.out.println("typeInPerson is not enabled or clickable.");
        }
	}
    
    public void clickOnRadioFirstAvailableDate() {
		if (firstAvailableDate.isEnabled()) {
            // If the button is enabled, click it
			firstAvailableDate.click();
            System.out.println("firstAvailableDate clicked successfully.");
        } else {
            System.out.println("firstAvailableDate is not enabled or clickable.");
        }
	}
    
    public void clickOnChooseAnotherDate() {
		if (chooseAnotherDate.isEnabled()) {
            // If the button is enabled, click it
			chooseAnotherDate.click();
            System.out.println("chooseAnotherDate clicked successfully.");
        } else {
            System.out.println("chooseAnotherDate is not enabled or clickable.");
        }
	}
    
    public void clickDatePicker() {
		if (datePicker.isEnabled()) {
            // If the button is enabled, click it
			datePicker.click();
            System.out.println("datePicker clicked successfully.");
        } else {
            System.out.println("datePicker is not enabled or clickable.");
        }
	}
    
    public void clickOnTimeSlot() {
		if (selectTimeSlot.isEnabled()) {
            // If the button is enabled, click it
			selectTimeSlot.click();
            System.out.println("selectTimeSlot clicked successfully.");
        } else {
            System.out.println("selectTimeSlot is not enabled.");
        }
	}
}
