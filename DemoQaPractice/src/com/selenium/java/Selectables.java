package com.selenium.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selectables {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver(options);		
		driver.get("https://demoqa.com/selectable");
		
		driver.manage().window().maximize();
		
		List<WebElement> ele= driver.findElements(By.xpath("//li[@class='mt-2 list-group-item list-group-item-action']"));
		for(WebElement e:ele) {
			if(e.getText().equals("Dapibus ac facilisis in") || e.getText().equals("Morbi leo risus")) {
				e.click();
				System.out.println(e.getSize().getHeight());
				System.out.println(e.getSize().getWidth());
			}
		}
		
	}

}
