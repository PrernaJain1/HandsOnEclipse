package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AfNestedFrame {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/nestedframes");

		//Switch to parent frame through id
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		System.out.println("Switched to Parent frame through id");
		String parentIframe = driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]")).getText();
		System.out.println(parentIframe);
		Thread.sleep(2000);
		//Switch to child frame through WebElement
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		System.out.println("Switch to Child frame through WebElement");
		String childIframe = driver.findElement(By.xpath("//p[contains(text(),'Child Iframe')]")).getText();
		System.out.println(childIframe);
		Thread.sleep(2000);
		//switching to parent frame
		//(If there is one frame inside another frame and we want to navigate back to first frame)
		driver.switchTo().parentFrame();
		System.out.println("Switched again to Parent frame");
		Thread.sleep(2000);

		driver.quit();
	}

}
