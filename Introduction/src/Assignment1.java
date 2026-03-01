import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1 {

	public static void main(String[] args) {
		//For allowing url to hit on browser
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
											
		//invoke browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver(options);
												
		//browser url
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
		//To select checkbox
		//<input id="checkBoxOption1" value="option1" name="checkBoxOption1" type="checkbox">
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//To deselect checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//to find count of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}
