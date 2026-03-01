package POM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Config.ConfigReader;
import UtilityFunctions.BaseClass;

public class LoginPage {
	WebDriver driver;
	ConfigReader r;
	BaseClass b;
	
	By usrname= By.xpath("//input[@placeholder='Username']");
	By passwd= By.cssSelector("input#password");
	By loginBtn=By.id("login-button");
	
	LoginPage(WebDriver driver){
		this.driver=driver;
		b=new BaseClass(driver);
	}
	
	public void login() throws IOException {
		r=new ConfigReader();
		driver.findElement(usrname).sendKeys(r.getData("username"));
		driver.findElement(passwd).sendKeys(r.getData("password"));
		//driver.findElement(loginBtn).click();
		b.doClick(loginBtn);
		
	}
}
