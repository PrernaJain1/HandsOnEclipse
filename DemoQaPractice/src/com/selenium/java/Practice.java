package com.selenium.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\120.0.6099.109\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		Actions a=new Actions(driver);
		
		WebElement w=driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		a.moveToElement(w).build().perform();
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//span[@class='a-expander-prompt']")).click();
	}

}
