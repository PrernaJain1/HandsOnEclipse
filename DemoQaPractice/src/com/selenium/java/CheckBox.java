package com.selenium.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demoqa.com/checkbox");

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("button[title='Toggle']")).click();

		//To check button is selected or not
		System.out.println(driver.findElement(By.xpath("(//span[@class='rct-text']//button[@type='button'])[1]")).isSelected());
		
		//To check button is displayed or not
		System.out.println(driver.findElement(By.xpath("(//span[@class='rct-text']//button[@type='button'])[1]")).isDisplayed());
				
		// driver.findElement(By.xpath("(//span[@class='rct-text']//button[@type='button'])[1]")).click();
		// driver.findElement(By.cssSelector("label[for='tree-node-downloads']")).click();

		Thread.sleep(5);
		//driver.findElement(By.cssSelector("label[for='tree-node-downloads']")).click();

		// driver.findElement(By.xpath("//span[text()='Downloads']")).click();

		// driver.findElement(By.cssSelector("input#tree-node-downloads")).click();
		
		//findElements is mandatory bcoz there are more than one element attached to one element
		List<WebElement> l = driver.findElements(By.tagName("label"));

		for (WebElement w : l) {
			if (w.getText().contains("Downloads")) 
			{
				w.click();
				break;
			}
		}

	}

}
