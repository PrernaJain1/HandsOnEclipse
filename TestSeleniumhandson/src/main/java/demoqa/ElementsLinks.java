package demoqa;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsLinks {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/links");

		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Links']")));
		//To locate link
		driver.findElement(By.linkText("Home")).click();

		//Handle multiple windows
		//It will navigate to child window
		String parentTab = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for(String tab : allWindows) {
			if(!parentTab.equals(tab)) {
			driver.switchTo().window(tab);
			Thread.sleep(5000);
			System.out.println("Switched to different tab");
			//image handling
			WebElement image = driver.findElement(By.tagName("img"));
			String source = image.getAttribute("src");
			System.out.println("Source :"+ source);
			}
		}

		//API call checking code
		driver.get("https://demoqa.com/links");
		driver.findElement(By.linkText("Created")).click();
		//Explicit wait - waiting for response
		WebElement response = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
		System.out.println("Response: "+ response);
		String message = response.getText();
		System.out.println(message);

		if(message.contains("201") && message.contains("Created")) {
			System.out.println("Verified API successfully");
		}
		else {
			System.out.println("API is not verified successfully");
		}
		driver.quit();
	}

}
