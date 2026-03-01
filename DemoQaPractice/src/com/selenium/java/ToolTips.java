package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ToolTips {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://demoqa.com/tool-tips");
		
		//To stop the screen F8 or ctrl+\(Keep ctrl pressed and then press slash 2-3 times)
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("toolTipButton"))).build().perform();
		
		Thread.sleep(5000);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText());

	}

}
