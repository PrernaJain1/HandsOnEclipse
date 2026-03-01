package com.selenium.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TextBox {

	public static void main(String[] args) throws InterruptedException {

		// For allowing url to hit on browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		//invoke browser
		WebDriver driver = new ChromeDriver(options);

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// To open link
		driver.get("https://demoqa.com/text-box");
		
		//To navigate to a particular link
		driver.navigate().to("https://youtube.com");

		//To refresh a page
		driver.navigate().refresh();

		//To navigate back to previous page
		driver.navigate().back();

		//To maximize window
		driver.manage().window().maximize();
		
		//By ID
		driver.findElement(By.id("userName")).sendKeys("Prerna");
		
		//Xpath(Relative)
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abcd@gmail.com");

		//Css selector
		driver.findElement(By.cssSelector("textarea#currentAddress")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("textarea[id='permanentAddress']")).sendKeys("1234");

		//wait
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".btn-primary")).click();
	}

}
