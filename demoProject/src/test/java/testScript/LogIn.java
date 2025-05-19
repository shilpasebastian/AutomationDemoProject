package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn extends Base{
	
	@Test
	
	public void logInTest() {
		
		String user_name="admin";
		String password="admin";
		WebElement userName_txt=driver.findElement(By.xpath("//input[@name='username']"));
		userName_txt.sendKeys(user_name);
		WebElement password_txt=driver.findElement(By.xpath("//input[@name='password']"));
		password_txt.sendKeys(password);
		WebElement signIn_btn=driver.findElement(By.xpath("//button[@type='submit']"));
		signIn_btn.click();	
		WebElement dash_board=driver.findElement(By.xpath("//p[text()='Dashboard']"));
		Boolean isHomePageAvailable=dash_board.isDisplayed();
		Assert.assertTrue(isHomePageAvailable);
		
	}

}
