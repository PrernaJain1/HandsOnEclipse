package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
		// Slider, Resizable, Selectable, Draggable and Droppable
		// To work on these topics need to install chrome extension named Page ruler smart
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		//System.setProperty("webdriver.chrome.driver","C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/dragabble");
		
		Actions a=new Actions(driver);
		
		//1)Simple
		WebElement dragme =driver.findElement(By.id("dragBox"));
		
		JavascriptExecutor script= (JavascriptExecutor) driver;
		script.executeScript("arguments[0].scrollIntoView();", dragme);
		
		Thread.sleep(10000);
		//Page ruler smart Chrome extension is used to locate x and y coordinates.
		a.moveToElement(dragme).clickAndHold().moveByOffset(548, 253).release().build().perform();
		
		//2) Axis restricted
		/*driver.findElement(By.id("draggableExample-tab-axisRestriction")).click();
		
		WebElement x=driver.findElement(By.id("restrictedX"));
		WebElement y=driver.findElement(By.id("restrictedY"));
		
		a.dragAndDropBy(x,441, 147).build().perform();
		a.dragAndDropBy(y,340, 174).build().perform();*/
		
		//3) Container Restricted
		/*driver.findElement(By.id("draggableExample-tab-containerRestriction")).click();
		
		WebElement w=driver.findElement(By.xpath("//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle']"));
		a.moveToElement(w).clickAndHold().moveByOffset(811, 97).release().build().perform();
		
		
		WebElement scrolling=driver.findElement(By.xpath("//div[@class='draggable ui-widget-content m-3']"));
		JavascriptExecutor script= (JavascriptExecutor) driver;
		script.executeScript("arguments[0].scrollIntoView();", scrolling);
		
		WebElement w2=driver.findElement(By.xpath("//span[@class='ui-widget-header ui-draggable ui-draggable-handle']"));
		a.dragAndDropBy(w2, 353, 131).build().perform();
		
		*/
	}

}
