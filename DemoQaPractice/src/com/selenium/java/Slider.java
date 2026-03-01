package com.selenium.java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//To open the browser in incognito mode
		options.addArguments("--incognito");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		//To open the url
		driver.get("https://jqueryui.com/slider/");
		
		//To go inside iframe
		WebElement iframe= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		
		//ele to drag and drop
		WebElement ele=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		
		Actions a=new Actions(driver);
		a.moveToElement(ele).clickAndHold().moveByOffset(181, 0).release().build().perform();
		
		Thread.sleep(5000);
		
		//To take screenshot
		TakesScreenshot ss= (TakesScreenshot) driver;
		File f= ss.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(f, new File("C:\\Users\\91914\\eclipse-workspace\\DemoQaPractice\\Screenshots\\ss.jpg"));
		//FileHandler.copy(f, new File("C:\\Users\\91914\\eclipse-workspace\\DemoQaPractice\\Screenshots\\ss1.jpg"));
				
		//to refresh the page
		driver.navigate().refresh();

	}

}
