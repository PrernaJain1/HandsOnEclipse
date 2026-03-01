package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import UtilityFunctions.BaseClass;
public class CricStats {
	WebDriver driver;
	BaseClass b;
	By stat = By.xpath("//a[text()='Stats']");
	By rohit_name = By.xpath("//a[text()='Rohit Sharma']");
	
	public CricStats(WebDriver driver) {
		this.driver=driver;
		b=new BaseClass(driver);
	}
	
	public void Stats() {
		b.doClick(stat);		
		b.getText(rohit_name);
	}
}
