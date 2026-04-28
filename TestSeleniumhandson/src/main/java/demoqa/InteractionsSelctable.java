package demoqa;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InteractionsSelctable {

	public static void main(String[] args) throws InterruptedException {
		//isSelected only works for:
		//check box
		//radio button
		//<option> inside drop down

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/selectable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		//List
		Thread.sleep(5000);
		List<WebElement> list= driver.findElements(By.xpath("//ul[contains(@class,'vertical-list-container')]//li[contains(@class,'list-group-item list-group-item-action')]"));
		for(WebElement li:list) {
			if(li.getText().equals("Morbi leo risus")) {
				li.click();
				System.out.println("Morbi Selected");
				Thread.sleep(2000);
				boolean selected= li.getAttribute("class").contains("active");
				System.out.println("Verified selected or not "+ selected);
				break;
			}
		}
		Thread.sleep(2000);

		driver.quit();
	}

}
