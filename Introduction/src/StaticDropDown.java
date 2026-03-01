import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		//For allowing url to hit on browser
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
						
			//invoke browser
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver_win32\\chromedriver.exe");	
			WebDriver driver= new ChromeDriver(options);
							
			//browser url
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			//We stored the webelement path in one variable
			WebElement staticdropdown =driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			
			//<select name="ctl00$mainContent$DropDownListCurrency" id="ctl00_mainContent_DropDownListCurrency" class="valid"></select>
			//We are going to handle a dropdown with the nature of select--> means it is a static dropdown
			Select dropdown= new Select(staticdropdown);
			
			Thread.sleep(1000);
			
			//Selecting the value in the dropdown on the basis of index 
			dropdown.selectByIndex(3);       //USD
			System.out.println(dropdown.getFirstSelectedOption().getText()); //It will print the selected option i.e. USD
			
			Thread.sleep(1000);
			
			//Selecting the value in the dropdown on the basis of Visible text 
			dropdown.selectByVisibleText("AED");       //AED
			System.out.println(dropdown.getFirstSelectedOption().getText()); //It will print the selected option i.e. AED
			
			Thread.sleep(1000);
			
			//Selecting the value in the dropdown on the basis of attribute value 
			//<option value="INR">INR</option>
			dropdown.selectByValue("INR");       //INR
			System.out.println(dropdown.getFirstSelectedOption().getText()); //It will print the selected option i.e. INR
			
			//To click on passengers dropdown
			driver.findElement(By.id("divpaxinfo")).click();
			
			Thread.sleep(1000);
			
			//To get the text for passenger dropdown
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			
			//To click on plus icon
			for(int i=0;i<4;i++)
			{
			driver.findElement(By.id("hrefIncAdt")).click();
			}
			
			//To get the count for passenger dropdown
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			
			Thread.sleep(1000);
			
			driver.findElement(By.id("btnclosepaxoption")).click();
			//driver.close();
	}

}
