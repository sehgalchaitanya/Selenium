package TestPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestDataProvider {
	
	@DataProvider(name = "CustomData")
	public Object [][] testDataMethod(){
		
		Object [][] testData = {{"sehgal.chaitanya@gmail.com","$Rayaansh@12$"},{"test123","test123"}};
		
		return testData;
	}

}


// Login Link - //a[@class='ga_nav_link nav-utility-login']
