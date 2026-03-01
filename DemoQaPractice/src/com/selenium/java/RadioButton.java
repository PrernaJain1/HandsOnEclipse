package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButton {

	public static void main(String[] args) {
		
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://demoqa.com/radio-button");
		
		//To click o radio button
		driver.findElement(By.xpath("//label[text()='Impressive']")).click();
		
		//Clicking on text of radio button
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'disabled')]")).isEnabled());

		//To check radio button is enabled or not
		System.out.println(driver.findElement(By.id("noRadio")).isEnabled());
	}

}
