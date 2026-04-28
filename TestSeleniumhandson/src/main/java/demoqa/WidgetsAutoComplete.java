package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WidgetsAutoComplete {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/auto-complete");

		//Multiple color names
		Thread.sleep(2000);
		WebElement textBox1 =driver.findElement(By.xpath("(//div[contains(@class,'auto-complete__input-container')])[1]"));
		Actions a = new Actions(driver);
		//Sending one letter to the text box
		a.moveToElement(textBox1).click().sendKeys("B").build().perform();
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		System.out.println("Black selected");
		Thread.sleep(2000);
		//To send a particular value
		//Entering multiple values in same text box
		a.sendKeys("Yellow").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		System.out.println("Yellow selected");
		Thread.sleep(5000);
		//Single color name
		WebElement textBox2 =driver.findElement(By.xpath("(//div[contains(@class,'auto-complete__input-container')])[2]"));
		Actions a2 = new Actions(driver);
		a2.moveToElement(textBox2).click().sendKeys("Q").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		System.out.println("Aqua selected");
		Thread.sleep(2000);
		driver.quit();
	}

}
