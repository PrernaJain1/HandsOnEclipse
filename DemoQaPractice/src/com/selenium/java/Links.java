package com.selenium.java;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	public static void main(String[] args) {
		
//		ChromeOptions options= new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/links");
		
		//On clicking it will open a new Tab
		driver.findElement(By.linkText("Home")).click();
		
		
		//It will give the current tab(parent) loc
		String parentTab=driver.getWindowHandle();
		
		//It will give all tabs in s
		Set<String> s=driver.getWindowHandles();
		
		//To switch to child tab
		for(String str:s) {
			if(!str.equals(parentTab)) {
				driver.switchTo().window(str);
			}
		}
		
		//To check any element in the child tab 
		System.out.println(driver.findElement(By.xpath("//h5[text()='Elements']")).getText());
	
	}

}
