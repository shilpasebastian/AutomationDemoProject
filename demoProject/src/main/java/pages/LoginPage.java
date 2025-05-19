package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);//driver--->local driver, this----->current class instance driver
		//initElements is used to initialize webElements
	}
	
	@FindBy(xpath="//input[@name='username']") WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") WebElement signIn_btn;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dash_board;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alert_box;


	public void enterUserName(String userName) {
		
		usernameField.sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		
		passwordField.sendKeys(password);
		
	}
	
	public void clickTheSignInButton() {
		
		signIn_btn.click();
		
	}
	
	public boolean isDashBoardDisplayed() {
		
		return dash_board.isDisplayed();
		
		
	}
	
	public boolean isAlertDisplayed() {
		
		return alert_box.isDisplayed();
		
		
	}


}
