package test.Utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass
{
	
	@DataProvider(name = "Data")
	public static Object[][] getData() throws IOException
	{
	   String path = System.getProperty("user.dir") + "//testData//Userdata.xls";
	   XLUtility xl = new XLUtility(path);
	   int rownum = xl.getRowCount("Sheet1");
	   int colnum = xl.getCellCount("Sheet1", 1);
	   
	   Object[][] data = new Object[rownum][colnum];
	   
	   for(int i=1; i<=rownum; i++)
	   {
		   for(int j=0; j<colnum; j++)
		   {
			   data[i-1][j] = xl.getCellData("Sheet1", i, j);
		   }
	   }
	   System.out.println(data.toString());
	   return data;
		
	}
}