package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AfModalDialogs {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/modal-dialogs");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		//small modal
		driver.findElement(By.id("showSmallModal")).click();
		String text = driver.findElement(By.xpath("//div[@class='modal-header']")).getText();
		System.out.println("Small Modal Text: "+ text);
		driver.findElement(By.id("closeSmallModal")).click();
		Thread.sleep(2000);

		//Large modal
		driver.findElement(By.id("showLargeModal")).click();
		String textLarge = driver.findElement(By.xpath("//div[contains(@class,'modal-title')]")).getText();
		System.out.println("Large Modal Text: "+ textLarge);
		driver.findElement(By.id("closeLargeModal")).click();
		Thread.sleep(2000);

		driver.quit();
	}

}
