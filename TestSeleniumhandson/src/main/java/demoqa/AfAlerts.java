package demoqa;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AfAlerts {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		//Simple Alert
		driver.findElement(By.id("alertButton")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		System.out.println("Simple alert accepted");
		Thread.sleep(2000);

		//Alert appear after 5 seconds
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(5000);
		Alert a1= driver.switchTo().alert();
		a1.accept();
		System.out.println("Alert appear after 5 seconds accepted");
		Thread.sleep(2000);

		//Confirmation alert
		driver.findElement(By.id("confirmButton")).click();
		Alert a2 = driver.switchTo().alert();
		a2.dismiss();
		System.out.println("Alert canceled");
		Thread.sleep(2000);

		//Prompt alert
		driver.findElement(By.id("promtButton")).click();
		Alert a3 = driver.switchTo().alert();
		a3.sendKeys("Prerna");
		a3.accept();
		System.out.print("Prompt alert accepted");
		Thread.sleep(2000);

		driver.quit();
	}

}
