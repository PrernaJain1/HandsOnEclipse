package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class InteractionsSortable {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/sortable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		//List
		//drag element five to first position
		Thread.sleep(5000);
		WebElement one = driver.findElement(By.xpath("//div[@class='list-group']//div[text()='One']"));
		WebElement four = driver.findElement(By.xpath("//div[@class='list-group']//div[text()='Four']"));
//		JavascriptExecutor javaScript = (JavascriptExecutor)driver;
//		javaScript.executeScript("arguments[0].scrollIntoView(true);",five);
		Actions a = new Actions(driver);
		a.clickAndHold(four).moveToElement(one).release().build().perform();
		System.out.println("List Sorted");
		Thread.sleep(2000);

		//Grid
		driver.findElement(By.id("demo-tab-grid")).click();
		WebElement two = driver.findElement(By.xpath("//div[@class='create-grid']//div[text()='Two']"));
		WebElement six = driver.findElement(By.xpath("//div[@class='create-grid']//div[text()='Six']"));
		Actions a1 = new Actions(driver);
		a1.dragAndDrop(six, two).build().perform();
		System.out.print("Grid Sorted");
		Thread.sleep(2000);

		driver.quit();
	}

}
