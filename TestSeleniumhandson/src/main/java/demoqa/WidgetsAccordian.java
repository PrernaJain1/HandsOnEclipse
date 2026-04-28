package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WidgetsAccordian {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/accordian");

		//Click on drop down
		driver.findElement(By.xpath("(//div[contains(@class,'accordion-item')])[1]")).click();
		Thread.sleep(5000);
		//get text from drop down
		String text = driver.findElement(By.xpath("(//div[contains(@class,'accordion-body')])[1]")).getText();
		System.out.println("Text : "+ text);
		Thread.sleep(2000);
		driver.quit();
	}

}
