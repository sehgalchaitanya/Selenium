package test.Utilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataProvider {
	
	
	@DataProvider(name = "LoginData")
	public Object[][] getData(){
		
		Object [][] data = {{"Admin","admin123"}};
		return data;
	}
	
	@DataProvider(name = "WebLoginData")
	public String[][] getWebLoginData(){
		
		String [][] webData = {{"chaitanyasehgal","Rayaansh@12"}};
		return webData;
	}
	
	@DataProvider(name = "WebLoginDataFromExcel")
	public Object[][] getDataFromExcel() throws IOException {
        String path = System.getProperty("user.dir") + "/testData/Userdata.xls";
        System.out.println("The path is: " + path);
        XLUtility xl = new XLUtility(path);
        String sheetName = "Sheet1";
        int rownum = xl.getRowCount(sheetName);
        int colnum = xl.getCellCount(sheetName, 1);

        System.out.println("Value of rownum is: " + rownum);
        System.out.println("Value of colnum is: " + colnum);

        // Temporary list to hold non-empty rows
        List<String[]> tempData = new ArrayList<String[]>();

        for (int i = 1; i <= rownum; i++) {
            String[] rowData = new String[colnum];
            boolean isEmptyRow = true;
            for (int j = 0; j < colnum; j++) {
                rowData[j] = xl.getCellData(sheetName, i, j);
                if (!rowData[j].isEmpty()) {
                    isEmptyRow = false;
                }
            }
            // Add to tempData if the row is not empty
            if (!isEmptyRow) {
                tempData.add(rowData);
            }
        }

        // Convert tempData to a two-dimensional array
        String[][] webDataFromExcel = new String[tempData.size()][colnum];
        for (int i = 0; i < tempData.size(); i++) {
            webDataFromExcel[i] = tempData.get(i);
        }

        System.out.println("Just before returning the webDataFromExcel");
        return webDataFromExcel;
    }
	

}
