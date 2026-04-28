package demoqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ElementsCheckBox {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver();
		//Maximize window
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		Thread.sleep(2000);
		
		//Remove add
		((JavascriptExecutor) driver).executeScript(
			    "document.querySelectorAll('iframe, .ad, #adplus-anchor, .google-anno-skip, ins').forEach(el => el.remove());"
			);
		Thread.sleep(3000);

		//Navigating to tab check box
		driver.findElement(By.xpath("//span[text()='Check Box']")).click();
		//click on '+' button
		driver.findElement(By.cssSelector("span.rc-tree-switcher")).click();
		//Fetching the element through list
		List<WebElement> list = driver.findElements(By.className("rc-tree-title"));
		int cnt =1;
		for(WebElement li:list) {
			if(li.getText().equals("Downloads")) {
				Thread.sleep(2000);
				System.out.println(li.getText());
				System.out.println(cnt);
				WebElement checkbox = driver.findElement(By.xpath("(//span[@class='rc-tree-checkbox'])["+ cnt +"]"));
				checkbox.click();
				Thread.sleep(2000);
				break;
			}
			cnt++;
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
