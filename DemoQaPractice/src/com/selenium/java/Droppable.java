package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Droppable {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/droppable");
		
		//Simple
		/*
		WebElement dragme= driver.findElement(By.id("draggable"));
		WebElement drophere= driver.findElement(By.id("droppable"));
		
		Actions a=new Actions(driver);
		a.dragAndDrop(dragme, drophere).build().perform();
		
		System.out.println(driver.findElement(By.id("droppable")).getText());
		*/
		
		//Accept
		/*
		driver.findElement(By.id("droppableExample-tab-accept")).click();
		
		Thread.sleep(3000);
		
		WebElement accept= driver.findElement(By.id("acceptable"));
		WebElement nonaccept= driver.findElement(By.id("notAcceptable"));
		WebElement drophere= driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']"));
		
		Actions a=new Actions(driver);

		//Method 1:
		a.dragAndDrop(nonaccept, drophere).build().perform();
		System.out.println(drophere.getText());
		
		//Method 2:
		a.moveToElement(accept).clickAndHold().moveToElement(drophere).release().build().perform();
		System.out.println(drophere.getText());
		*/
		
		//Prevent Propagation
		driver.findElement(By.id("droppableExample-tab-preventPropogation")).click();
		WebElement dragme=driver.findElement(By.id("dragBox"));
		
		Actions a=new Actions(driver);
		
		//Not greedy
		WebElement notgreedyInnerbox= driver.findElement(By.id("notGreedyInnerDropBox"));
		a.dragAndDrop(dragme, notgreedyInnerbox).build().perform();
		System.out.println(driver.findElement(By.xpath("//div[@id='notGreedyDropBox']//p[1]")).getText()+ "Outer Box");
		System.out.println(driver.findElement(By.xpath("//div[@id='notGreedyInnerDropBox']//p")).getText()+ " Inner Box");
		
		Thread.sleep(1000);
		
		//Greedy
		WebElement greedyInnerbox= driver.findElement(By.cssSelector("#greedyDropBoxInner"));
		Thread.sleep(4000);
		
		//To scroll to the element
		JavascriptExecutor script= (JavascriptExecutor) driver;
		script.executeScript("arguments[0].scrollIntoView();",greedyInnerbox);
		
		a.moveToElement(dragme).clickAndHold().moveToElement(greedyInnerbox).release().build().perform();
		//a.dragAndDrop(dragme, greedyInnerbox).build().perform();
		
		System.out.println(driver.findElement(By.xpath("//div[@id='greedyDropBox']//p[1]")).getText()+ " Outer box");
		System.out.println(driver.findElement(By.xpath("//div[@id='greedyDropBoxInner']//p")).getText()+ " Inner box");
		
		//Revert Draggable
		
		
	}

}
