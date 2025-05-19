package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'list-news' )and contains(@class,'nav-link')]") WebElement manageNewsOPtion;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newBtn;
	@FindBy(xpath ="//textarea[@id='news']") WebElement newsTextarea;
	@FindBy(xpath ="//button[@type='submit']") WebElement saveBtn;
	@FindBy(xpath ="//button[@data-dismiss='alert']") WebElement alert;

	public void clickManageNewsOption() {
	
	manageNewsOPtion.click();
	}
	
	public void clickNewButton() {
		
		newBtn.click();
	}
	
	public void enterNews(String news) {
		
		newsTextarea.sendKeys(news);
	}
	
	public void clickSaveButton() {
		
		saveBtn.click();
	}
	
	public boolean isAlertDisplayed() {
		
		return alert.isDisplayed();
	}
}
