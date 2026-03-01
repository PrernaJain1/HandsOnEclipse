package com.selenium.java;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	public static void main(String[] args) throws InterruptedException {
		// ChromeOptions options= new ChromeOptions();
		// options.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.chrome.driver","C:\\Users\\91914\\.cache\\selenium\\chromedriver\\win64\\122.0.6261.69\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		// 1)Click Button to see alert
		/*driver.findElement(By.id("alertButton")).click();
		  Thread.sleep(5000); 
		  //For switching to alert 
		  Alert a=driver.switchTo().alert(); 
		  Thread.sleep(3000);
		  //On that alert...for clicking on ok 
		  a.accept(); */

		// 2)On button click, alert will appear after 5 seconds
		/*driver.findElement(By.id("timerAlertButton")).click(); 
		  Thread.sleep(6000);
		  Alert a= driver.switchTo().alert(); 
		  Thread.sleep(6000); 
		  a.accept(); */

		// 3)On button click, confirm box will appear
		/*Thread.sleep(5000);
		 
		 //To scroll to a particular webElement use Java script executor
		 JavascriptExecutor script=(JavascriptExecutor)driver;
		 script.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.id("confirmButton"))); 
		 
		 driver.findElement(By.id("confirmButton")).click();
		 Thread.sleep(3000); 
		 Alert a= driver.switchTo().alert();
		 
		 //To click on cancel button in alert 
		  a.dismiss();
		 
		 Actions ac=new Actions(driver);
		 ac.moveToElement(driver.findElement(By.id("confirmButton")));
		 ac.click().build().perform(); Thread.sleep(3000); Alert
		 a=driver.switchTo().alert(); Thread.sleep(2000); 
		 //To click on cancel button in alert 
		 a.dismiss();
		 */

		// 4)On button click, prompt box will appear
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(1000);
		Alert a = driver.switchTo().alert();
		Thread.sleep(1000);
		a.sendKeys("Ajhg");
		a.accept();

		// To get the text whatever we entered
		System.out.println(driver.findElement(By.id("promptResult")).getText());
	}

}
