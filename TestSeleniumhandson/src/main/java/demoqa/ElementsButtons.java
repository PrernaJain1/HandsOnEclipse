package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ElementsButtons {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");
		Thread.sleep(2000);

		//Remove add
				((JavascriptExecutor) driver).executeScript(
					    "document.querySelectorAll('iframe, .ad, #adplus-anchor, .google-anno-skip, ins').forEach(el => el.remove());"
					);

		//Actions class
		Actions a = new Actions(driver);
		//Double Click
		WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
		a.moveToElement(doubleClickButton).doubleClick().build().perform();
		Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(),"You have done a double click");
		Thread.sleep(2000);
		//Right Click
		WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
		a.moveToElement(rightClickButton).contextClick().build().perform();
		Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).getText(),"You have done a right click");
		Thread.sleep(2000);
		//Click
		WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
		a.moveToElement(clickMeButton).click().build().perform();
		Assert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).getText(),"You have done a dynamic click");
		Thread.sleep(2000);

		driver.quit();
	}

}
