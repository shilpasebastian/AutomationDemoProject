package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	
	WebDriver driver;
	
	public AdminUserPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}	
	@FindBy(xpath="//a[contains(@class,'small-box-footer') and contains(@href,'admin/list-admin')]") WebElement more_info_btn;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement new_btn;
	@FindBy(xpath="//input[@id='username']") WebElement userName_txt;
	@FindBy(xpath="//input[@id='password']") WebElement password_txt;
	@FindBy(xpath="//select[contains(@class,'form-control') and contains(@id,'user_type')]") WebElement userType_ddl;
	@FindBy(xpath="//button[@name='Create']") WebElement save_btn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert_box;
	
		
	public void clickMoreInfo() {
		
		more_info_btn.click();
	}

	public void clickNewButton() {
		
		new_btn.click();
	}
	
	public void enterUserName(String username) {
		
		userName_txt.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		
		password_txt.sendKeys(password);
	}
	
	public void selectUserTypeDropDwon(String value) {
		
		Select select=new Select(userType_ddl);
		select.selectByValue(value);
		
	}
	
	public void clickSaveButton() {
		
		save_btn.click();
	}
	
	public boolean isAlertDisplayed() {
		
		return alert_box.isDisplayed();
		
	}
	
}
