package web.tests.BaseTests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTestsForWeb {
	
	public Logger logger;
	public WebDriver driver; 
	public WebDriverWait wait;
	
	public void logSetup(){
		//logs
		logger = LogManager.getLogger(this.getClass());
	}
    
    
    public void setup(){
        System.out.println("Start of setup() method......");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("End of setup() method......");
    }
    
    public void scrollBottomOfPage() throws InterruptedException {
    	// Scroll to the bottom of the page
		  System.out.println("Now scrolling to bottom of the page");
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
             Thread.sleep(2000);
    }
    

    public void tearDown() {
        if(driver != null) {
       //    driver.quit();
            System.out.println("Quit the driver......");
        }
    }

}
