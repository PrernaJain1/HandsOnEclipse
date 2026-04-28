package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class InteractionsResizeable {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/resizable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		Thread.sleep(3000);
		//Resizing
		WebElement ele =driver.findElement(By.xpath("//div[@class='constraint-area']//span[contains(@class,\"react-resizable-handle\")]"));
		Actions a = new Actions(driver);
		a.clickAndHold(ele).moveByOffset(275,80).release().build().perform();
		System.out.print("Resizing done!");
		Thread.sleep(2000);

		driver.quit();
	}

}
