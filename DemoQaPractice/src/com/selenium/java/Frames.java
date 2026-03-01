package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frames {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		
		//To open url
		driver.get("https://demoqa.com/frames");
		
		//To maximize window
		driver.manage().window().maximize();
		
		//We can't access Iframe elements until we enter inside that Iframe.
		//If we are inside Iframe we cannot access outside elements.
		
		//Going inside iframe
		
		//Three ways by which we can switch to Iframe 
		//1)index- give the index of iframe which you want to access //driver.switchTo().frame(2);
		//2)ID - driver.switchTo().frame("frame1");
		//3)WebElement- driver.findElement(By.id("frame1")) this will return webElement
		
		//By WebElement switching to frame 1
		//driver.switchTo().frame(driver.findElement(By.id("frame1")));
		
		//By WebElement switching to frame 1
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
		
		//By Index switching to iframe
		//driver.switchTo().frame(2);
		
		//Now navigating to heading inside iframe and printing its text
		System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
		
		//Now to come out of iframe to the webpage
		driver.switchTo().defaultContent();
		
		//switching to parent frame 
		//(If there is one frame inside another frame and we want to navigate back to first frame)
		driver.switchTo().parentFrame();
		
		//Now trying to access element from Webpage
		System.out.println(driver.findElement(By.xpath("//div[@id='framesWrapper']//div[1]")).getText());
		
		//now switching to frame 2 through ID on webpage
		driver.switchTo().frame("frame2");
		
		//Trying to access element of frame 2
		System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
		//here xpath is same as that of frame1 but it will access frame 2 as we have navigated inside frame 2
	}

}
