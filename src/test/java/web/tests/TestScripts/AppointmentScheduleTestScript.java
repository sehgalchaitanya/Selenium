package web.tests.TestScripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.tests.POM.LandingPage;

public class AppointmentScheduleTestScript extends FrontDoorTestScript {

	 	@BeforeClass
	    public void setUp() {
	        super.logSetup();
	        super.setup();
	    }

	    @AfterClass
	    public void tearDown() {
	        super.tearDown();
	    }
	    
	    @Test
	    public void preRequisite() throws InterruptedException {
	    	FrontDoorTestScript fs = new FrontDoorTestScript();
	    	fs.navigateToFrontDoorScreen();
	    	fs.testFrontDoorSignIn("2ebtestncal1", "pleasanton02");
	    	fs.feedbackBannerOnLandingPage();
	    }
	    
	    // This method is not getting called, need to look into this
	    @Test
	    public void clickOnAppointments_Care() {
	    	System.out.println("START of clickOnAppointments_Care() method......Outside try block");
	    	
	    	try {
	        	System.out.println("START of clickOnAppointments_Care() method......in try block");
	        	LandingPage lps = new LandingPage(driver);
	        	System.out.println("menuOption_Appt_Care displayed yes or no :" + lps.menuOption_Appt_Care.isDisplayed());
	        	wait.until(ExpectedConditions.visibilityOf(lps.menuOption_Appt_Care));
	            if (lps.menuOption_Appt_Care.isDisplayed()) {
	                lps.clickMenuOption_Appt_Care();
	                System.out.println("Clicked the MenuOption_Appt_Care button successfully");
	            }
	        } catch (Exception e) {
	            System.out.println("No MenuOption_Appt_Care button or unable to click.");
	        }
	    	System.out.println("END of clickOnAppointments_Care() method......");
	    }
}
