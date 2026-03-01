package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Menu {

	public static void main(String[] args) throws InterruptedException {
		//ChromeOptions option=new ChromeOptions();
		//option.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\120.0.6099.109\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://demoqa.com/menu");
		
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		
		//If we want to pause the script then: 
		//press fn+F12 to open inspect element
		//navigate to source then press ctrl+\.
		//Then navigate to element tab to locate the element
		//Resume through source tab by clicking on blue color resume button
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[text()='Main Item 2']"))).build().perform();
		
		Thread.sleep(4000);
		WebElement w= driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		a.moveToElement(w).build().perform();
		System.out.println(w.getText());
		
	}

}
