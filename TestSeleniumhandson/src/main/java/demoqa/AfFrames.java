package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AfFrames {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		//We can't access Iframe elements until we enter inside that Iframe.
		//If we are inside Iframe we cannot access outside elements.

		//Going inside iframe
		//Three ways by which we can switch to Iframe
		//1)index- give the index of iframe which you want to access //driver.switchTo().frame(2);
		//Index starts from 0-> 1st frame will be zero index
		//2)ID - driver.switchTo().frame("frame1");
		//3)WebElement- driver.findElement(By.id("frame1")) this will return webElement

		//Now navigating to heading inside iframe and printing its text
		WebElement f = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(f);
		String frameText = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Frame 1 Text : "+ frameText);
		Thread.sleep(2000);

		//Now to come out of iframe to the webpage
		driver.switchTo().defaultContent();
		String defaultText =driver.findElement(By.xpath("//h1[@class='text-center']")).getText();
		System.out.println("Default Text: "+ defaultText);
		Thread.sleep(2000);

		//Scrolling to frame 2
		//Jaascript executor applicable only for elements not text
		WebElement frame2 = driver.findElement(By.id("frame2"));
		JavascriptExecutor script = (JavascriptExecutor)driver;
		script.executeScript("arguments[0].scrollIntoView(true);",frame2);

		//now switching to frame 2 through index on webpage
		//Trying to access element of frame 2
		driver.switchTo().frame(1);
		String frame2text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Frame 2 Text "+ frame2text);
		Thread.sleep(2000);

		driver.quit();
	}

}
