package com.selenium.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBar {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://demoqa.com/progress-bar");
		
		//Fluent wait
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(1));
		//To click on start button
		WebElement w= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startStopButton")));
		w.click();
		
		//Explicit wait
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement w= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startStopButton")));
		
		
		//To click on stop button when progress bar is on 35%
		while(true) {
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("progressBar"))).getText().equals("35%")) {
				w.click();
				break;
			}
		}
	}

}
