package demoqa;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AfBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//New Tab
		driver.findElement(By.id("tabButton")).click();
		String parentTab = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();

		for(String win : allWindow) {
			if(!win.equals(parentTab)) {
				driver.switchTo().window(win);
				System.out.println("Switched to child tab");
				break;
			}
		}
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parentTab);
		Thread.sleep(5000);

		//New Window
		driver.findElement(By.id("windowButton")).click();
		Thread.sleep(2000);
		Set<String> allWindow1 = driver.getWindowHandles();

		for(String win1 : allWindow1) {
			if(!win1.equals(parentTab)) {
				driver.switchTo().window(win1);
				System.out.println("Switched to New Window");
				System.out.println(driver.findElement(By.id("sampleHeading")).getText());
				break;
			}
		}
		driver.close();
		driver.switchTo().window(parentTab);

		//New Window message
		driver.findElement(By.id("messageWindowButton")).click();
		Thread.sleep(2000);
		Set<String> allWindow2 = driver.getWindowHandles();

		for(String win2 : allWindow2) {
			if(!win2.equals(parentTab)) {
				driver.switchTo().window(win2);
				System.out.println("Switched to New Window Message");
				break;
			}
		}

		Thread.sleep(5000);
		driver.quit();
	}

}
