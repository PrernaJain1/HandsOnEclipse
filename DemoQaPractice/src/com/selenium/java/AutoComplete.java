package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AutoComplete {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://demoqa.com/auto-complete");
		
		Actions a= new Actions(driver);
		//In text box we can enter multiple values
		a.moveToElement(driver.findElement(By.xpath("//div[@class='auto-complete__value-container auto-complete__value-container--is-multi css-1hwfws3']"))).click().sendKeys("A").build().perform();	
		
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		//To select second value
		a.sendKeys("Yellow").sendKeys(Keys.ENTER).build().perform();
		
		
		//In text box we can enter only one color
		
		//In this we will send one or two letters in text box
		a.moveToElement(driver.findElement(By.xpath("//div[@class='auto-complete__value-container css-1hwfws3']"))).click().sendKeys("A").build().perform();
		
		//We will move cursor down to the element we want to select
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(5000);
		
		//To select new color we have to click again and give color
		a.click().sendKeys("Black").build().perform();
		
		Thread.sleep(1000);
		
		a.sendKeys(Keys.ENTER).build().perform();
		 
	}

}
