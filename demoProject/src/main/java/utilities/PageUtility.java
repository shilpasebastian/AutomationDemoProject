package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {

	//PageUtility is used to help page classes
	
	//Select Class methods
	
	public void selectByVisibleText(WebElement element,String visibleText) {
		
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);
		
	}
	
	public void selectByVisibleValue(WebElement element,String value) {
		
		Select select =new Select(element);
		select.selectByValue(value);
		
	}
	
	public void selectByIndex(WebElement element,int index) {
		
		Select select =new Select(element);
		select.selectByIndex(index);
		
	}
	
	//Action Class methods
	
	public void click(WebDriver driver,WebElement element) {
		
		Actions action=new Actions(driver);
		action.click(element).build().perform();	
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		
		Actions action=new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
	public void rightClick(WebDriver driver,WebElement element) {
		
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement drag,WebElement drop) {
		
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	//JavaScriptExcecuter methods
	
	public void scrollUsingJavaScriptExcecuter(WebDriver driver,String value1,String value2) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(value1,value2);
	}
	
	public void clickUsingJavaScriptExcecuter(WebDriver driver,String value,WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(value,element);
	}
	
	public void sendKeysUsingJavaScriptExcecuter(WebDriver driver,String value,WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(value,element);
	}
	
	//Wait methods
	
	public void implicityWait(WebDriver driver,int seconds) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public void explicitWait(WebDriver driver,int seconds,WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void fluentWait(WebDriver driver,int totalSeconds,int polling,WebElement element) {
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(totalSeconds))
				.pollingEvery(Duration.ofSeconds(polling))
				.ignoring(NoSuchElementException.class);
				fluentWait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
}
