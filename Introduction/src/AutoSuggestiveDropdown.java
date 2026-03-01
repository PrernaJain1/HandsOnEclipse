import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		//Auto suggestive dropdowns where the option comes on the basis of ur input
		
		//For allowing url to hit on browser
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
							
		//invoke browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver(options);
								
		//browser url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//To send some data in input
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		
		Thread.sleep(3000);
		
		List<WebElement> option1= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		//Navigating to all suggested options and comparing
		for(WebElement op: option1) {
			if(op.getText().equalsIgnoreCase("India")) {
				op.click();
				break;
			}
		}
	}

}
