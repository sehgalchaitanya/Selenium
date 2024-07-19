package SeleniumTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		// get the title of the window
		System.out.println(driver.getTitle());
		//get window handle - ID of current window
		System.out.println(driver.getWindowHandle());
		
		//click on a link
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		//get window handles - IDs of all windows
		Set<String> windowids = driver.getWindowHandles();
		System.out.println(windowids);
		System.out.println("Total Number of windows: " + windowids.size());
		
        for(String windowId : windowids) {
        	System.out.println(windowId);
        }
		
		
		
		driver.quit();
		
		
		
		
	}

}
