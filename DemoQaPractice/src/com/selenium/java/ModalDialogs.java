package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ModalDialogs {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://demoqa.com/modal-dialogs");
		
		//In modals a new box will open just like in alerts. But in modals we will be able to access the elements in that box as well
		driver.findElement(By.xpath("//button[text()='Small modal']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[text()='This is a small modal. It has very less content']")).getText());
		
		driver.findElement(By.id("closeSmallModal")).click();
	}

}
