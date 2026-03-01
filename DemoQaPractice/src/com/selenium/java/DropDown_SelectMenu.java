package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDown_SelectMenu {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://demoqa.com/select-menu");
		
		driver.manage().window().maximize();
		
		//in select we have 3 functions:
		//Select by value
		//Select by index
	    //Select by visible text
		
		//old style select menu
		WebElement w=driver.findElement(By.id("oldSelectMenu"));
		Select s=new Select(w);
		
		s.selectByIndex(1);
		Thread.sleep(5000);
		s.selectByValue("5");
		Thread.sleep(5000);
		s.selectByVisibleText("Yellow");
		
		WebElement c=driver.findElement(By.id("cars"));
		Select s1= new Select(c);
		
		//Scroll to the end of page
		JavascriptExecutor script= (JavascriptExecutor) driver; 
		script.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		s1.selectByValue("saab");
		s1.selectByValue("volvo");
		Thread.sleep(3000);
		s1.deselectAll();
		//s1.deselectByIndex(0);
		//s1.deselectByValue(null);
		//s1.deselectByVisibleText(null)
		
		//Scroll back to the top of the page
		//JavascriptExecutor script= (JavascriptExecutor) driver; 
		script.executeScript("window.scrollBy(0,-(document.body.scrollHeight))");
		
	}

}
