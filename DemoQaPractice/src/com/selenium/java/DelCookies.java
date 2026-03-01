package com.selenium.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DelCookies {

	public static void main(String[] args) {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		
		//Running chrome browser in headless mode 
		options.addArguments("--headless");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/date-picker");
		
		//To delete all cookies from chrome driver
		driver.manage().deleteAllCookies();
		System.out.println("Done!");
		
		
	}

}
