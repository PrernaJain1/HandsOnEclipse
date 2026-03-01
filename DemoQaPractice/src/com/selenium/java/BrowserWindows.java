package com.selenium.java;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindows {

	public static void main(String[] args) {
	
//		ChromeOptions options= new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(); //chrome driver getting launched		
		driver.get("https://demoqa.com/browser-windows");
		
		//To click on new Tab
		/*driver.findElement(By.id("tabButton")).click();
		String parentTab=driver.getWindowHandle();
		Set<String> tabs=driver.getWindowHandles();
		
		for(String s:tabs) {
			if(!s.equals(parentTab)) {
				driver.switchTo().window(s);
			}
		}
		
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		*/
		
		//To click on new window
		driver.findElement(By.id("windowButton")).click();
		String parentTab=driver.getWindowHandle();
		Set<String> tabs=driver.getWindowHandles();
		
		for(String s:tabs) {
			if(!s.equals(parentTab)) {
				driver.switchTo().window(s);
			}
		}
		
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		//New window message
	}

}

