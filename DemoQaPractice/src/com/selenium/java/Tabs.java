package com.selenium.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tabs {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://demoqa.com/tabs");
		
		List<WebElement> l= driver.findElements(By.xpath("//nav[@class='nav nav-tabs']//a"));
		
		//System.out.println(l.size());
		
		for(WebElement w: l) {
			//System.out.println(w.getText());
			
			if(w.getText().equals("Origin")){
				w.click();
				System.out.println(driver.findElement(By.xpath("//div[@class='tab-content']")).getText());
				break;
			}
		}
		
	}

}