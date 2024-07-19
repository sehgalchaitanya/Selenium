package web.tests.TestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.Utilities.LoginDataProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import web.tests.BaseTests.BaseTestsForWeb;
import web.tests.POM.FrontDoor;
import web.tests.POM.FrontDoorSignIn;
import web.tests.POM.LandingPage;
import web.tests.POM.ScheduleAppointments;
import web.tests.Utilities.ScreenshotUtility;
import web.test.URL.WebURL;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class FrontDoorTestScript extends BaseTestsForWeb {

	 @BeforeClass
	    public void setUp() {
	        super.logSetup();
	        super.setup();
	    }

	    @AfterClass
	    public void tearDown() {
	        super.tearDown();
	    }
	    
	
    @Test(priority=1)
    public void navigateToFrontDoorScreen() throws InterruptedException {
        System.out.println("######################Start of navigateToFrontDoorScreen() method......" + "Printing the driver object: " + driver);
        
        driver.get(WebURL.FrontDoorURL);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        handleCookiesBanner();
        FrontDoor door = new FrontDoor(driver);
        door.clickSignInButton();
        System.out.println("#######################End of navigateToFrontDoorScreen() method......");
    }
    
 // Method to handle cookies banner
        public void handleCookiesBanner() {
        try {
        	 System.out.println("############################Start of handleCookiesBanner method......");
        	 FrontDoor door = new FrontDoor(driver);
        	 wait.until(ExpectedConditions.visibilityOf(door.acceptAllButton));
            if (door.acceptAllButton.isDisplayed()) {
                door.clickAcceptAllButton();
                System.out.println("Accepted cookies.");
            }
        } catch (Exception e) {
            System.out.println("No cookies banner found or unable to accept cookies.");
        }
    }
        
 /*       // Method to check if the Sign In failed due to incorrect username or password
        @Test(priority=3)
        public void signInFailed() {
        	FrontDoorSignIn fd = new FrontDoorSignIn(driver);
        	wait.until(ExpectedConditions.visibilityOf(fd.errorMessageElement));
        	System.out.println("Error Message is Displayed?: " + fd.errorMessageElement.isDisplayed());
        	if(fd.errorMessageElement.isDisplayed()) {
        		System.out.println("Sign-in is failed, Error Message :" + fd.errorMessageElement.getText());
        	}
        	else{
        		System.out.println("Sign-in is passed");
        	}
        } */
    
  @Test(priority=2, dataProvider = "WebLoginDataFromExcel", dataProviderClass = test.Utilities.LoginDataProvider.class)
  	public void testFrontDoorSignIn(String user, String pass) throws InterruptedException {
    //public void testFrontDoorSignIn() throws InterruptedException {
	  System.out.println("##################################Start of testFrontDoorSignIn method with user: " + user);
        FrontDoorSignIn fd = new FrontDoorSignIn(driver);
        wait.until(ExpectedConditions.visibilityOf(fd.userID));
        fd.enterUsername(user);
        System.out.println("Entered the username: " + user);
        wait.until(ExpectedConditions.visibilityOf(fd.password));
        fd.enterPassword(pass);
        System.out.println("Entered the password : " + pass);
        wait.until(ExpectedConditions.elementToBeClickable(fd.signInButton));
        fd.clickSignIn();
        System.out.println("Clicked on sign in for user: " + user);
        System.out.println("#################################End of testFrontDoorSignIn method for user: " + user);
        
        Thread.sleep(5000);
        
        //Wait for the title to be present and assert the title
        
      /*  wait.until(ExpectedConditions.titleIs("Welcome, EB NCAL Validation"));
        System.out.println("Print the title: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Welcome, EB NCAL Validation", "Page title after sign-in does not match expected title.");
       */   
  }
  
  @Test(priority=3, dependsOnMethods = {"testFrontDoorSignIn"})
  public void feedbackBannerOnLandingPage() {
	  
	  try {
     	LandingPage lp = new LandingPage(driver);
     	wait.until(ExpectedConditions.visibilityOf(lp.noButtonOnFeedbackBanner));
         if (lp.noButtonOnFeedbackBanner.isDisplayed()) {
             lp.clickNoButtonOnFeedbackBanner();
             System.out.println("Selected No to feedback");
         }
     } catch (Exception e) {
         System.out.println("No feedback banner found or unable to accept feedback.");
         System.out.println(e.getMessage());
     }
	  
  } 
  
  @Test(priority=4)
  public void clickOnAppointments_Care() {
	    
  try {
	   // feedbackBannerOnLandingPage();
	  	LandingPage lp = new LandingPage(driver);
      	System.out.println("##############################START of clickOnAppointments_Care() method......" + lp.menuOption_Appt_Care.isDisplayed());
      	System.out.println("menuOption_Appt_Care displayed yes or no :" + lp.menuOption_Appt_Care.isDisplayed());
      	
      	wait.until(ExpectedConditions.visibilityOf(lp.menuOption_Appt_Care));
          if (lp.menuOption_Appt_Care.isDisplayed()) {
              lp.clickMenuOption_Appt_Care();
              System.out.println("Clicked the MenuOption_Appt_Care button successfully");
          }
  }
   catch(Exception e){
    	  System.out.println("No MenuOption_Appt_Care button or unable to click.");
    	  System.out.println(e.getMessage());
    	  System.out.println(e.getLocalizedMessage());
         }
      System.out.println("######################END of clickOnAppointments_Care() method......######################");

  }
  
  @Test(priority=5)
  public void navigateToScheduleAnAppointment() throws NoSuchElementException, TimeoutException {
	    
  try {
	   // feedbackBannerOnLandingPage();
	  	Thread.sleep(5000);
	  	LandingPage lp = new LandingPage(driver);
      	System.out.println("############################START of navigateToScheduleAnAppointment()() method......" + lp.scheduleAnAppointmentLink.isDisplayed());
      	System.out.println("menuOption_Appt_Care displayed yes or no :" + lp.scheduleAnAppointmentLink.isDisplayed());
      	wait.until(ExpectedConditions.visibilityOf(lp.scheduleAnAppointmentLink));
          if (lp.scheduleAnAppointmentLink.isDisplayed()) {
              lp.clickScheduleAnAppointmentLink();
              System.out.println("Clicked the scheduleAnAppointmentLink successfully");
              Assert.assertEquals(driver.getTitle(), "Appointment Center");
          }
  }
   catch(Exception e){
    	  System.out.println("No scheduleAnAppointmentLink or unable to click.");
    	  e.printStackTrace();
         }
  		
      System.out.println("######################END of navigateToScheduleAnAppointment() method......##################");
  }
  
  //scheduleMedicalAppointmentButton
  
  @Test(priority=6)
  public void goToscheduleMedicalAppointment() {    
  try {
	 feedbackBannerOnLandingPage();
	  LandingPage lp = new LandingPage(driver);
      	System.out.println("###########################START of goToscheduleMedicalAppointment() method......" + lp.scheduleMedicalAppointmentButton.isDisplayed());
      	System.out.println("scheduleMedicalAppointmentButton displayed yes or no :" + lp.scheduleMedicalAppointmentButton.isDisplayed());
      	wait.until(ExpectedConditions.visibilityOf(lp.scheduleMedicalAppointmentButton));
          if (lp.scheduleMedicalAppointmentButton.isDisplayed()) {
              lp.clickscheduleMedicalAppointmentButton();
              System.out.println("Clicked the scheduleMedicalAppointmentButton successfully");
              Assert.assertEquals(driver.getTitle(), "Schedule appointment");
              Assert.assertEquals(driver.getPageSource().contains("You can schedule up to 4 total appointments for you and other members under your care."), true);             
          }
  }
   catch(Exception e){
    	  System.out.println("No scheduleMedicalAppointmentButton or unable to click.");
    	  e.printStackTrace();
         }
  		
      System.out.println("###################END of goToscheduleMedicalAppointment() method......#########################");
  }
  
  @Test(priority=7, dependsOnMethods = {"goToscheduleMedicalAppointment"})
  public void selectPrimaryIconPlusForAppointment() {
	  try {
		  System.out.println("##################START of selectPrimaryIconPlusForAppointment() method......#################");
		  feedbackBannerOnLandingPage();
		  Thread.sleep(2000);
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  // Make the x-path generic so that it works for all data
		/*  if (driver.findElement(By.xpath("//label[@class='memberName']")).getText().contains("TEST C-NONLINEBLINK")) {
			    sa.clickPrimaryIconPlus();
			}
		*/
		  sa.clickPrimaryIconPlus();
	  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the Primary for Schedule Appointment");
    	  e.printStackTrace();
	  }
	  System.out.println("#################END of selectPrimaryIconPlusForAppointment() method......####################");
  }
  
  @Test(priority=8, dependsOnMethods = {"selectPrimaryIconPlusForAppointment"})
  public void selectNextButtonInScheduleAppointmentPage() {
	  try {
		  System.out.println("#################START of selectNextButtonInScheduleAppointmentPage() method......################");
		//  feedbackBannerOnLandingPage();
		  	super.scrollBottomOfPage();
		  
	      
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.nextButtonInSheduleAppointmentPage));
		  sa.clickNextButtonInSheduleAppointmentPage();
		  wait.until(ExpectedConditions.titleIs(driver.getTitle()));
		  Assert.assertEquals(driver.getTitle(), "Schedule appointment");
	  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the NextButton in Schedule Appointment page");
		  e.printStackTrace();
	  }
	  System.out.println("#####################END of selectNextButtonInScheduleAppointmentPage() method......##################");
  }
  
  @Test(priority=9, dependsOnMethods = {"selectNextButtonInScheduleAppointmentPage"})
  public void selectFacilityDropdown() {
	  try {
		  System.out.println("####################START of selectFacilityDropdown() method......######################");
	//	  feedbackBannerOnLandingPage();
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.facilityDropdown));
		  Select dropdown = new Select(sa.facilityDropdown);
		  
		  List <WebElement> options = dropdown.getOptions();
		  
		  for(WebElement x: options) {
			  if(x.getText().equalsIgnoreCase("Sacramento Medical Center")) {
				  System.out.println("Now inside the if condition");
				  Thread.sleep(2000);
				  x.click();
				  System.out.println("Successfully selected this facility from dropdown: " + x.getText());
				  break;
			  }			    
		  }
		 // Assert.assertEquals(sa.facilityDropdown.isDisplayed(), true);
		 // sa.clickOnFacilityDropdown();
	  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the facility from dropdown in Schedule Appointment page");
		  e.printStackTrace();
	  }
	  System.out.println("#######################END of selectFacilityDropdown() method......######################");
  }
  
  @Test(priority=10)
  public void selectNextButtonInScheduleAppointmentPageAgain() {
	  try {
		  System.out.println("###########################START of selectNextButtonInScheduleAppointmentPageAgain() method......#############");
		  feedbackBannerOnLandingPage();
		  	// Scroll to the bottom of the page
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		  
	      
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.nextButtonInSheduleAppointmentPage));
		  sa.clickNextButtonInSheduleAppointmentPage();
	  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the NextButton in Schedule Appointment page");
		  e.printStackTrace();
	  }
	  System.out.println("#########################END of selectNextButtonInScheduleAppointmentPageAgain() method......###############");
  }
  
  @Test(priority=11)
  public void selectRadioIllnesOtherConcerns() {
	  try {
		  System.out.println("###############START of selectRadioIllnesOtherConcerns() method......############");
		  //feedbackBannerOnLandingPage();
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.radioIllnesOtherConcerns));
		  System.out.println("The selected xpath is for: " + sa.radioIllnesOtherConcerns.getText());
		  if(sa.radioIllnesOtherConcerns.getText().contains("Illness/Other concern")) {
		  sa.clickOnRadioIllnesOtherConcerns();
		  }
		  else
		  {
			  System.out.println("the selected xpath is not for Illness/Other concern");
		  }
		  Thread.sleep(2000);
		
	    //Select the mandatory checkbox before continue scheduling appointment
		  System.out.println("Waiting for checkboxContinueSchedulingApt to be visible...");
	        wait.until(ExpectedConditions.visibilityOf(sa.checkboxContinueSchedulingApt));
	        sa.clickOncheckboxContinueSchedulingApt();
	        Thread.sleep(2000);
	     // Scroll to the bottom of the page
			  System.out.println("Now scrolling to bottom of the page");
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		        
	        Thread.sleep(2000);
	    //    selectNextButtonInScheduleAppointmentPageAgain();
		  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the radio button reason IllnesOtherConcerns Schedule Appointment page");
		  e.printStackTrace();
	  }
	  System.out.println("###############END of selectRadioIllnesOtherConcerns() method......###############");
  }
  
  @Test(priority=12)
  public void selectRadioReasonReturnOrFollowUp() {
	  try {
		  System.out.println("###############START of selectRadioReasonReturnOrFollowUp() method......############");
		//  feedbackBannerOnLandingPage();
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.reasonReturnOrFollowUp));
		  sa.clickOnRadioReasonReturnOrFollowUp();
		  Thread.sleep(5000);
	
	     // Scroll to the bottom of the page
		  super.scrollBottomOfPage();
		        
	        Thread.sleep(2000);
	    //    selectNextButtonInScheduleAppointmentPageAgain();
		  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the radio button reason ReturnOrFollowUp Schedule Appointment page");
		  e.printStackTrace();
	  }
	  System.out.println("###############END of selectRadioReasonReturnOrFollowUp() method......###############");
  }
  
  @Test(priority=13)
  public void selectRadioTypeInPerson() {
	  try {
		  System.out.println("###############START of selectRadioTypeInPerson() method......############");
		//  feedbackBannerOnLandingPage();
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.typeInPerson));
		  sa.clickOnRadioTypeInPerson();
		  Thread.sleep(5000);

	     // Scroll to the bottom of the page
		  super.scrollBottomOfPage();
		        
	        Thread.sleep(2000);
	        selectNextButtonInScheduleAppointmentPageAgain();
		  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the radio button TypeInPerson");
		  e.printStackTrace();
	  }
	  System.out.println("###############END of selectRadioTypeInPerson() method......###############");
  }
  
/*  //firstAvailableDate
  @Test(priority=14)
  public void selectRadioFirstAvailableDate() {
	  try {
		  System.out.println("###############START of selectRadioFirstAvailableDate() method......############");
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.firstAvailableDate));
		  sa.clickOnRadioFirstAvailableDate();
		  Thread.sleep(5000);
	
	     // Scroll to the bottom of the page
			  System.out.println("Now scrolling to bottom of the page");
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		        
	        Thread.sleep(2000);
	        selectNextButtonInScheduleAppointmentPageAgain();
		  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the radio button FirstAvailableDate");
		  e.printStackTrace();
	  }
	  System.out.println("###############END of selectRadioFirstAvailableDate() method......###############");
  } 
*/
  
  @Test(priority=14)
  public void selectRadioChooseAnotherDate() {
	  try {
		  System.out.println("###############START of selectRadioChooseAnotherDate() method......############");
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.chooseAnotherDate));
		  sa.clickOnChooseAnotherDate();
		  Thread.sleep(5000);
	
	     // Scroll to the bottom of the page
			  super.scrollBottomOfPage();
		        
	        Thread.sleep(2000);
	       // selectNextButtonInScheduleAppointmentPageAgain();
		  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the radio button ChooseAnotherDate");
		  e.printStackTrace();
	  }
	  System.out.println("###############END of selectRadioChooseAnotherDate() method......###############");
  } 
  
//firstAvailableDate
  @Test(priority=15)
  public void selectDatePicker() {
	  try {
		 
		  System.out.println("###############START of selectDatePicker() method......############");
		//  feedbackBannerOnLandingPage();
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.datePicker));
		  sa.clickDatePicker();
		  Thread.sleep(2000);
		  super.scrollBottomOfPage();
		  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the DatePicker");
		  e.printStackTrace();
	  }
	  System.out.println("###############END of selectDatePicker() method......###############");
  }  
  
  @Test(priority=16)
  public void selectMonthFromCalendar() throws NoSuchElementException, InterruptedException, TimeoutException {
	  try {
		 
		  System.out.println("###############START of selectMonthFromCalendar() method......############");
		//  feedbackBannerOnLandingPage();
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.calMonth));
		  String monthYear = "August 2024";
		  String day = "20";
		  
		  String text = sa.calMonth.getText();
		  System.out.println("Current month on calendar is: " + text);
		  
		  
		  while(true) {
			 if(text.contains(monthYear)) {
				 break;
			 }
			 else {
				//button[@aria-label='Show September 2024']
				 WebElement weNext = driver.findElement(By.xpath("//button[@class='icon-chevron-forward next' and @type='button' and contains(@aria-label, 'Show')]"));
				 wait.until(ExpectedConditions.visibilityOf(weNext));
				 weNext.click();
			 }
			 
			 List<WebElement> we = driver.findElements(By.xpath("//*[@id=\"cal-modal-container-0\"]/div/table/tbody/tr/td"));
			  for(WebElement x: we) {
				  
				  if(x.getText().equals("20")) {
					  System.out.println("Printing the dates from calendar: " + x.getText());
					  x.click();
				  } 
			  }
		  }
		  Thread.sleep(2000);
		  
		   
		  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the Month Date from Calendar");
		  e.printStackTrace();
	  }
	  System.out.println("After catch block.....");
	  selectNextButtonInScheduleAppointmentPageAgain();
	  Thread.sleep(2000);
	  System.out.println("Control back to the method");
	  Thread.sleep(5000);
	 // WebElement textOnPage = driver.findElement(By.xpath("//p[@class='p2 inky']"));
	 // wait.until(ExpectedConditions.visibilityOf(textOnPage));
	//  System.out.println("Printing the page source: " + driver.getPageSource());
	  System.out.println("true or false: " + driver.getPageSource().contains("Select a time for your appointments"));
	  Assert.assertEquals(driver.getPageSource().contains("Select a time for your appointments"), true, "This condition is failied");
	  System.out.println("###############END of selectMonthFromCalendar() method......###############");
  } 
  
//Select Time Slot - First Time slot on the page
  @Test(priority=17)
  public void selectTimeSlot() throws NoSuchElementException, InterruptedException {
	  try {
		  System.out.println("###############START of selectTimeSlot() method......############");
		//  feedbackBannerOnLandingPage();
		  Thread.sleep(2000);
		  ScheduleAppointments sa = new ScheduleAppointments(driver);
		  wait.until(ExpectedConditions.visibilityOf(sa.selectTimeSlot));
		  sa.clickOnTimeSlot();
		  Thread.sleep(2000);
		  super.scrollBottomOfPage();
		  selectNextButtonInScheduleAppointmentPageAgain();
		  Thread.sleep(5000);
		  Assert.assertEquals(driver.getPageSource().contains("Review and schedule"), true);
		  Assert.assertEquals(driver.getPageSource().contains("Review the details below. To make a change, select Edit."), true);
		  }
	  catch (Exception e) {
		  System.out.println("Some error happened while selecting the Time Slot");
		  e.printStackTrace();
	  }
	  
	  System.out.println("###############END of selectTimeSlot() method......###############");
  }  
}