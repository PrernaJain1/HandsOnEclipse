package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ElementsDynamicProperties {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/dynamic-properties");

		//Get color of element before changing
		WebElement colorButton = driver.findElement(By.id("colorChange"));
		String beforeColor = colorButton.getCssValue("color");
		System.out.println("Before Color : "+ beforeColor);

		//Wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("enableAfter")).isEnabled();
		driver.findElement(By.id("visibleAfter")).isDisplayed();

		//Get color of element after color change
		String afterColor= colorButton.getCssValue("color");
		System.out.println("After Color : "+ afterColor);

		if(!beforeColor.equals(afterColor)) {
			System.out.println("Color Changed");
		}
		else {
			System.out.println("Color Not Changed");
		}

		driver.quit();

	}

}
