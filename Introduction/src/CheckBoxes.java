import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxes {

	public static void main(String[] args) {
		//To use assertion we have to use concept like TestNg and Junit. For now using assertions from TestNG framework.
		//TestNG is one of the testing framework which we will use for building automation framework using selenium.
		//Assertion will help to validate the result selenium returned is expected or not
		//Add TestNG jar to the project then we can apply assertions.
		
		//For allowing url to hit on browser
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
									
		//invoke browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver(options);
										
		//browser url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				
		//To check checkbox is selected or not
		//<input id="ctl00_mainContent_chk_SeniorCitizenDiscount" type="checkbox" name="ctl00$mainContent$chk_SeniorCitizenDiscount">
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		org.testng.Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//To select the checkbox
		//<input id="ctl00_mainContent_chk_SeniorCitizenDiscount" type="checkbox" name="ctl00$mainContent$chk_SeniorCitizenDiscount">
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		//To check checkbox is selected or not
		//<input id="ctl00_mainContent_chk_SeniorCitizenDiscount" type="checkbox" name="ctl00$mainContent$chk_SeniorCitizenDiscount">		
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		org.testng.Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		
		//To check how many checkboxes are there on the page 
		//For this we need to return a locator which is common to all checkboxes. Below type is same.
		//<input id="ctl00_mainContent_chk_SeniorCitizenDiscount" type="checkbox" name="ctl00$mainContent$chk_SeniorCitizenDiscount">		
		//System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		org.testng.Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(),6);
		
	}

}
