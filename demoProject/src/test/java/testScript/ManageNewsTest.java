package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test
	
	public void mangeNewsTest() throws IOException {
		
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		String news=ExcelUtility.getStringData(0, 1, "managenewspage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		ManageNewsPage mange_news_page=new ManageNewsPage(driver);
		mange_news_page.clickManageNewsOption();
		mange_news_page.clickNewButton();
		mange_news_page.enterNews(news);
		mange_news_page.clickSaveButton();
		Boolean isAlertDisplayed=mange_news_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);
		
	}

}
