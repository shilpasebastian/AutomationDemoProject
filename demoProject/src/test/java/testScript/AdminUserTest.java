package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base{
	
	@Test
	
	public void adminUserTest() throws IOException {
		
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		
		String username_AdminUserTest=ExcelUtility.getStringData(0, 1, "adminuser");
		String password_AdminUserTest=ExcelUtility.getIntegerData(1, 1, "adminuser");
		String userType=ExcelUtility.getStringData(2, 1, "adminuser");
		AdminUserPage admin_user_page=new AdminUserPage(driver);
		admin_user_page.clickMoreInfo();
		admin_user_page.clickNewButton();
		admin_user_page.enterUserName(username_AdminUserTest);
		admin_user_page.enterPassword(password_AdminUserTest);
		admin_user_page.selectUserTypeDropDwon(userType);
		admin_user_page.clickSaveButton();
		Boolean isAlertDisplayed=admin_user_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);
		
	}

}
