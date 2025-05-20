package testScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Base {
	
	public WebDriver driver;
	
	@BeforeMethod
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
//		the value from crossbrowser is assigned to browser
		
//		driver=new ChromeDriver();
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			
			driver=new EdgeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		}
		else {
			
			throw new Exception("Inavlid Browser");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().window().maximize();
	}
	
//	@AfterMethod
//	
//	public void driverQuit() {
//		driver.quit();
//	}

}
