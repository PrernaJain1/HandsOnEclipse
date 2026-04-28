package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class InteractionsDraggable {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/dragabble");

		Thread.sleep(2000);
		//Simple
		WebElement simple = driver.findElement(By.id("dragBox"));
		Actions a = new Actions(driver);
		a.moveToElement(simple).clickAndHold().moveByOffset(300,150).release().build().perform();
		System.out.println("simple drag drop done!");
		Thread.sleep(5000);

		//Axis restricted
		driver.findElement(By.xpath("//button[@id='draggableExample-tab-axisRestriction']")).click();
		WebElement x = driver.findElement(By.id("restrictedX"));
		Actions a1 = new Actions(driver);
		a1.dragAndDropBy(x, 441, 150).build().perform();
		System.out.println("Axis restricted drag drop done!");
		Thread.sleep(5000);

		driver.quit();
	}

}
