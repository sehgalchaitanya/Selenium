package FirstPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

public class FirstTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); //driver is a reference of WebDriver interface that is holding the object of ChromeDriver Class
		
		System.out.println("Start of Program, the driver object is created: " + driver);
	
		driver.manage().window().maximize();
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.ebay.com");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		System.out.println("Sign in is clicked");
		
	//	driver.findElement(By.xpath("//div[@id='CentralArea']")).click();
		
	/*	WebElement element_userid = driver.findElement(By.xpath("//input[@id='userid']")); 
		boolean text_userid = element_userid.isEnabled();
        if(text_userid == true) {
        	System.out.println("userid textbox is enabled");
        	} else
        	System.out.println("userid textbox is not enabled");
        
        element_userid.sendKeys("sehgal.chaitanya"); */
		
		WebElement textuserid = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userid']")));
		textuserid.sendKeys("sehgal.chaitanya");		
		
		//driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("sehgal.chaitanya");
		
		WebElement signin = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='signin-continue-btn']")));
        
        signin.click();
       
        driver.quit();
	}

}
