package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HubClassTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void testSetup() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.hubspot.com/");
		Thread.sleep(2000);
	}
	@Test(dataProvider = "CustomData", dataProviderClass = TestPackage.TestDataProvider.class)
	public void testLogin(String testUser, String testPass) throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='ga_nav_link nav-utility-login']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(testUser);
		driver.findElement(By.xpath("//input[@id='current-password']")).sendKeys(testPass);
		driver.findElement(By.xpath("//i18n-string[normalize-space()='Log in']")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!= null) {
			driver.quit();
		}
	}

}
