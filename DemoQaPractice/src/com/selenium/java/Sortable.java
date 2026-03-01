package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/sortable");
		
		//For List
		/*
		WebElement one=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[text()='One']"));
		WebElement two=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[text()='Two']"));
		WebElement three=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[text()='Three']"));
		WebElement four=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[text()='Four']"));
		WebElement five=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[text()='Five']"));
		WebElement six=driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[text()='Six']"));
		
		//To drop the first element at sixth position
		Actions a=new Actions(driver);
		a.dragAndDrop(one, six).build().perform();
		*/
		
		//For Grid
		
		driver.findElement(By.id("demo-tab-grid")).click();
		
		WebElement one=driver.findElement(By.xpath("//div[@class='create-grid']//div[text()='One']"));
		WebElement five=driver.findElement(By.xpath("//div[@class='create-grid']//div[text()='Five']"));
		
		//To replace fifth ele with one
		Actions a=new Actions(driver);
		a.dragAndDrop(five, one).build().perform();
	}

}
