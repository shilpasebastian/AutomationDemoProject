package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import constant.Constants;
import utilities.ScreenShortUtility;
import utilities.WaitUtility;

public class Base {
	
	public WebDriver driver;
	public ScreenShortUtility scrshot;
	public FileInputStream referenceVariable;
	public Properties properties;

	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser") //same name using in crossbrowser xml file
		
//	public void initializeBrowser() {
//		
//		driver=new ChromeDriver();
//		driver.get("https://groceryapp.uniqassosiates.com/admin");
//		driver.manage().window().maximize();
//
//		
//	}
	
	public void initializeBrowser(String browser) throws Exception {
				
		try { 
			
			properties=new Properties();
			referenceVariable=new FileInputStream(Constants.CONFIGFILE);
			properties.load(referenceVariable);//load the url
			
		}catch (Exception e) {
			
			System.out.println("Invalid URL");
			
		}
		
//		the value from crossbrowser is assigned to browser

		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			
			driver=new EdgeDriver();
//			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		}
		else {
			
			throw new Exception("Inavlid Browser");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	
	public void driverQuit(ITestResult iTestResult) throws IOException{
		
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenShortUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
		
		
	}

}
