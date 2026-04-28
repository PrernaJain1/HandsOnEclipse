package demoqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ElementsWebTables {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();

		int cnt=1;
		// Get kierra salary
		List<WebElement> name = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')]//tbody//tr//td[1]"));

		for(WebElement li:name) {
			if(li.getText().equals("Kierra")) {
				System.out.println(cnt);
				System.out.println("Name: " + driver.findElement(By.xpath("(//table[contains(@class,'table-bordered')]//tbody//tr//td[1])["+ cnt +"]")).getText());
				System.out.println("Salary: " + driver.findElement(By.xpath("(//table[contains(@class,'table-bordered')]//tbody//tr//td[5])["+ cnt +"]")).getText());
			}
			cnt++;
		}

		//Add row
		driver.findElement(By.id("addNewRecordButton")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[text()='Registration Form']")).getText());

		driver.quit();
	}

}
