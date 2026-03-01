package com.selenium.java;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UploadDownloadFile {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//To set the default download location
		HashMap<String,String> h=new HashMap<String,String>();
		h.put("download.default_directory","C:\\Users\\91914\\Desktop\\SS\\");
		
		options.setExperimentalOption("prefs", h);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://demoqa.com/upload-download");
		
		Thread.sleep(5);
		
		//Download file
		driver.findElement(By.id("downloadButton")).click();
		
		
		//To upload a file
		driver.findElement(By.cssSelector(".form-control-file")).sendKeys("C:\\Users\\91914\\Desktop\\Goal\\Imp.txt");
	}

}
