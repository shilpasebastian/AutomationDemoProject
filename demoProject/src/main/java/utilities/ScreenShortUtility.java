package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShortUtility {
	
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException { 
 		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakeScreenshot interface used to capture the screen short
 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //call getScreenshotAs method to create a image file 
 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //it is used to which time the test case is fail Date class is used to get current date
 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); //used to specify the folder the file is generated
 		if (!f1.exists()) { //if the folder is not exist
 			f1.mkdirs(); //make directory
 		}
 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp+ ".png"; 
 		File finalDestination = new File(destination); 
 		FileHandler.copy(screenShot, finalDestination); //it is used to copy one file to another file
 	}

}
