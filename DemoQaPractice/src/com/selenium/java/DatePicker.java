package com.selenium.java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/date-picker");
		/*
		//Clicked onSelect date dropdown
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		
		//Selecting month
		WebElement month=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select m=new Select(month);
		m.selectByVisibleText("April");
		
		//Selecting year
		WebElement year=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select y= new Select(year);
		y.selectByValue("2017");
		
		//Selecting date
		List<WebElement> allDatesCurrent=driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day')]"));
		List<WebElement> outsideDates=driver.findElements(By.xpath("//div[contains(@class,'--outside-month')]"));
		List<WebElement> currentDatesReq= new ArrayList<WebElement>() ;
		
		for(WebElement w: allDatesCurrent) {
			if(!w.getText().equals(outsideDates)) {
				currentDatesReq.add(w);
			}
		}
		
		for(WebElement w1: currentDatesReq) {
			if(w1.getText().equals("27")) {
				w1.click();
				break;
			}
		}
		*/
		
		//Date and Time
		
		WebElement datepicker=driver.findElement(By.id("dateAndTimePickerInput"));
		
		JavascriptExecutor script=(JavascriptExecutor) driver;
		script.executeScript("arguments[0].scrollIntoView();",datepicker);
		
		datepicker.click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//ul[contains(@class,'react-datepicker__time-list')]//li[text()='20:30']")).click();
	
	}

}
