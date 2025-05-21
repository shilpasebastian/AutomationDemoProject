package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	@Test(groups= {"regression"})
	
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		
//		String user_name="admin";   //----------->is called credentials
//		String password="admin";	
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		Boolean isHomePageAvailable=login_page.isDashBoardDisplayed();
		Assert.assertTrue(isHomePageAvailable);
		
	}
	
	@Test
	
	public void verifyTheUserIsUnableToLoginUsingInvalidUserNameAndValidPassword() throws IOException {
			
		String user_name=ExcelUtility.getStringData(3, 0, "loginpage");
		String password=ExcelUtility.getStringData(3,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		Boolean isAlertDisplayed=login_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);
		
	}
	
	@Test
	
	public void verifyTheUserIsUnableToLoginUsingValidUserNameAndInvalidPassword() throws IOException {
		
		String user_name=ExcelUtility.getStringData(2, 0, "loginpage");
		String password=ExcelUtility.getStringData(2, 1, "loginpage");
	    LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		Boolean isAlertDisplayed=login_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);
	}
	
	@Test
	
	public void verifyTheUserIsAbleToLoginUsingInvalidCredentials() throws IOException {
		
		String user_name=ExcelUtility.getStringData(4, 0, "loginpage");
		String password=ExcelUtility.getStringData(4, 1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		Boolean isAlertDisplayed=login_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);
	}
	
	
	

}
