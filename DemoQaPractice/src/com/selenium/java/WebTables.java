package com.selenium.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTables {

	public static void main(String[] args) {
		
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://demoqa.com/webtables");
		
		int index=1;
		//Absolute xpath
		//To get the list of all first names
		List<WebElement> l=driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td'][1]"));
		
		//Iterating over the list of first names till we get Kierra. Will print Kierra mail id
		for(WebElement w:l) {
			if(w.getText().equals("Kierra")) {
				System.out.println(driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']["+ index +"]//div[@class='rt-td'][4]")).getText());
				break;
			}
			index++;
		//System.out.println(l);
		}
	}

}
