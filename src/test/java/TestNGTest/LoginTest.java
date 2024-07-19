package TestNGTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import test.Utilities.DataProviderClass;
import test.Utilities.LoginDataProvider;

//@Listeners(Listener.CustomListener.class)
public class LoginTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.out.println("This is START of setup method...............");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		System.out.println("This is END of setup method...............");
	}
	
	//@Test(dataProvider = "Data", dataProviderClass = DataProviderClass.class)
	@Test(dataProvider = "LoginData", dataProviderClass = LoginDataProvider.class)
	public void loginTest(String user, String pass) throws InterruptedException 
	{
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(user);
		//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("This is START of test login method...............");
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement userElement = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		userElement.sendKeys(user);
		
		WebElement passElement = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		passElement.sendKeys(pass);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		String pageSource = driver.getPageSource();
		//System.out.println(pageSource);
		if(pageSource.contains("Dashboard")) {
			System.out.println("Login is successful");
		}
		else
		{
			System.out.println("Login failed");
		}
		
		System.out.println("This is END of test login method...............");
	}
	
	@Test
	public void skipTest() {
		System.out.println("This is skip test..");
		throw new SkipException("This is skip Exception..");
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("This is the tearDown method.....");
		driver.quit();
	} 

}
