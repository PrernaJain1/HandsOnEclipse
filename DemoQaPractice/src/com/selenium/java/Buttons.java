package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Buttons {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		// To open url
		driver.get("https://demoqa.com/buttons");

		// To perform double click and right click using actions class
		Actions a = new Actions(driver);
		
		// To store the webelment in double button
		WebElement double_button = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
		
		//To perform double click
		a.moveToElement(double_button).doubleClick().build().perform();
		
		//To check if it is giving correct output
		Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(),"You have done a double click","Data not matched");
		
		Thread.sleep(5000);
		
		// To perform right click
		WebElement right_button = driver.findElement(By.id("rightClickBtn"));
		
		//To perform right click
		a.moveToElement(right_button).contextClick().build().perform();
		
		//To check if it is giving correct output
		driver.findElement(By.id("rightClickMessage"));
		
		//To check if it is giving correct output
		org.testng.Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).getText(),"You have done a right click","Data not matched");
		
		Thread.sleep(5000);
		
		// To perform normal click
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
	}

}
