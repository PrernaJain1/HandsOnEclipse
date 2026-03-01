package UtilityFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	WebDriver driver;
	
	public BaseClass(WebDriver driver){
		this.driver=driver;
	}
	
	public void doClick(By locator) {
		driver.findElement(locator).click();
	}
	
	public void getText(By locator) {
		System.out.println(driver.findElement(locator).getText());
	}
	
	public void doClear() {
		
	}
}
