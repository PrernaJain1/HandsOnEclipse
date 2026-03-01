package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import UtilityFunctions.BaseClass;

public class CricHomePage {
	WebDriver driver;
	BaseClass b1;
	
	By series = By.xpath("//a[text()='Series']");
	By englandIndia= By.xpath("//a[contains(text(),'England tour of India, 2024')]");
	By seriesList= By.xpath("//div[@id='seriesDropDown']//a[contains(@class,'cb-subnav-item')]");
	
	public CricHomePage(WebDriver driver){
		this.driver=driver;
		b1=new BaseClass(driver);
	}
	
	public void moveToSeries() throws InterruptedException {
		Actions a=new Actions(driver);
		WebElement ele= driver.findElement(series);
		a.moveToElement(ele).build().perform();
		Thread.sleep(4000);
	}
	
	public void btnClickEngTour() throws InterruptedException {
		 b1.doClick(englandIndia);
		 Thread.sleep(4000);
	}
	
	public void printLinks() {
		List<WebElement> links =driver.findElements(seriesList);
		for(WebElement w:links) {
			System.out.println(w.getAttribute("href"));
	}
}
}
