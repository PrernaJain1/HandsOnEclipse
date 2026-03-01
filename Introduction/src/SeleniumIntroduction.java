import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		
		//For allowing url to hit on browser
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//invoke browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Desktop\\chrome_driver_113_version\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver(options);
		
		//browser url
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//for title
		System.out.println(driver.getTitle());

	}

}
