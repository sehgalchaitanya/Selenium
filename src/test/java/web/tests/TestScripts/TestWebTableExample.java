package web.tests.TestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import web.tests.BaseTests.BaseTestsForWeb;

public class TestWebTableExample extends BaseTestsForWeb {
	
	@BeforeClass
	public void preSetup() {
		super.logSetup();
		super.setup();
	}
	
	@AfterClass
	public void finish() {
		super.tearDown();
	}
	
	@Test(priority=1)
	public void launchWeb() throws InterruptedException {
		
		try {
		System.out.println("Start of launchWeb() method.....");
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();        
		wait.until(ExpectedConditions.titleIs(driver.getTitle()));
		System.out.println("Printing title: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "HTML Tables");
		
		}
		catch (Exception e) {
			System.out.println("Error occurred insite launchWeb() method.....");
			e.printStackTrace();
		}
		
		System.out.println("End of launchWeb() method.....");
	}
	

	@Test(priority=2, dependsOnMethods = {"launchWeb"})
	public void valueExistsInWebTable() {
		try {
			System.out.println("Start of valueExistsInWebTable() method.....");
			
			/*		// Capturing the Column values in List of WebElements
			   		List <WebElement> we = driver.findElements(By.xpath("//table[@class='ws-table-all' and @id='customers']/tbody/tr/th"));
					
					for(WebElement x: we) {
						System.out.println(x.getText());
					}
			*/		
					//Capturing the size of Columns or Column numbers
					int colnum = driver.findElements(By.xpath("//table[@class='ws-table-all' and @id='customers']/tbody/tr/th")).size();
					System.out.println("The colnum is: " + colnum);
					
					int rownum = driver.findElements(By.xpath("//table[@class='ws-table-all' and @id='customers']/tbody/tr")).size();
					System.out.println("The rownum is: " + rownum);
					
					//Printing all the values in the Web Table
					for(int i=2; i<=rownum; i++) {
						for(int j=1; j<=colnum; j++) {
							String xp = "//table[@class='ws-table-all' and @id='customers']/tbody/tr[" + i + "]/td[" + j + "]";
							WebElement wb = driver.findElement(By.xpath(xp)); 
							System.out.println("The value of the element at " +i+ ":" + j + " is: " + wb.getText());
						}
					}
		}
		
		catch (Exception e) {
			System.out.println("Unexpected error occured inside valueExistsInWebTable() method.....");
			e.printStackTrace();
		}
	
		System.out.println("End of valueExistsInWebTable() method.....");
	}
}
