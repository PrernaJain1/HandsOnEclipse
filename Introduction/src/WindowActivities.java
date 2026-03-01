import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowActivities {

	public static void main(String[] args) {
		//First invoke chrome browser
		
				//For allowing url to hit on browser
					ChromeOptions options=new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
							
				//invoke browser
					//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver_win32\\chromedriver.exe");
					//Now the above step is optional.If we don't provide this line selenium manager feature will get on and it will work. 
					//if we write this line then selenium manager feature will be turned off.
					
					WebDriver driver= new ChromeDriver(options);
					
		//To maximize window
					driver.manage().window().maximize();
					
		//To open a page... It will wait until page all components gets fully loaded
					driver.get("http://google.com");
					
		//To navigate to another page...In this it will not wait for the components to get fully loaded
					driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
					
		//to navigate to previous page
					driver.navigate().back();			
					
		//to navigate to next page
					driver.navigate().forward();
					
		System.out.println("Done");
		//driver.close();

	}

}
