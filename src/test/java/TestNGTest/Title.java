package TestNGTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.Utilities.LoginDataProvider;

public class Title {
	
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.out.println("This is executed before method.....");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "LoginData", dataProviderClass = LoginDataProvider.class)
	public void checkTitle(String user, String pass) throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		System.out.println("Title check done");
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("This is executed after method.....");
		driver.quit();
	}

}
