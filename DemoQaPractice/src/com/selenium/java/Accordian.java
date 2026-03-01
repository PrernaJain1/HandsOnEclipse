package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Accordian {

	public static void main(String[] args) {
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\122.0.6261.69\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/accordian");
		
		//Clicking on dropdown
		driver.findElement(By.id("section1Heading")).click();
		
		//getting the text of dropdown
		System.out.println(driver.findElement(By.xpath("//div[@class='card-body']")).getText());

	}

}
