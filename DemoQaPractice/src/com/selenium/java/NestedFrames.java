package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NestedFrames {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		// To open URL
		driver.get("https://demoqa.com/nestedframes");

		// We will go inside Parent frame
		driver.switchTo().frame(driver.findElement(By.id("frame1")));

		// We will print text of parent frame
		System.out.println(driver.findElement(By.xpath("//body[text()='Parent frame']")).getText());

		// We will go to child frame inside parent frame
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

		// We will print text of child frame
		System.out.println(driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText());

		// Now to go back to parent frame
		driver.switchTo().parentFrame();
		
		// We will print text of parent frame
		System.out.println(driver.findElement(By.xpath("//body[text()='Parent frame']")).getText());

	}

}
