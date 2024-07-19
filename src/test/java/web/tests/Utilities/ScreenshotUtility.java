package web.tests.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtility {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // Call getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination
        File destFile = new File("./reports/" + fileName + ".png");

        // Copy file at destination
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot taken: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error while taking screenshot: " + e.getMessage());
        }
    }
}
