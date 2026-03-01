import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		//For allowing url to hit on browser
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
							
		//invoke browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver(options);
								
		//browser url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//To click on 'from' dropdown
				//<input id="ctl00_mainContent_ddl_originStation1_CTXT" name="ctl00_mainContent_ddl_originStation1_CTXT" selectedtext="" selectedvalue="" value="" class="select_CTXT" menuselection="false" autocomplete="off" style="width: 250px; height: 43px; border: 1px solid rgb(153, 153, 153);">
				driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
				
				//To select Bengaluru
				//Xpath for bengaluru - //a[@value='BLR']
				//<a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Bengaluru (BLR)" value="BLR"> Bengaluru (BLR)</a>
				driver.findElement(By.xpath("//a[@value='BLR']")).click();
				
				Thread.sleep(2000);
				
				//To select chennai
				//Parent xpath space child xpath
				//If we are not allowed to use indexes then we use parent child relationship
				driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
				
				Thread.sleep(6000);

				//To select current depart date in calendar
				//<a class="ui-state-default ui-state-highlight ui-state-active" href="#">18</a>	
				
				//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();		
				driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();
				
				
				//To check dropdown option should be disabled for return date.
				//<input name="ctl00$mainContent$view_date2" type="text" readonly="readonly" id="ctl00_mainContent_view_date2" class="custom_date_pic required home-date-pick valid" xpath="1">
				//<div id="Div1" class="picker-second" style="display: block; opacity: 1;" xpath="1">
						      
				if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
					System.out.println("Enabled");
					Assert.assertTrue(true);
				}
				else {
					System.out.println("Disabled");
					Assert.assertFalse(false);
				}
				
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
				
				//to click on done button
				driver.findElement(By.id("btnclosepaxoption")).click();
				
				//We stored the webelement path in one variable
				WebElement staticdropdown =driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				
				//<select name="ctl00$mainContent$DropDownListCurrency" id="ctl00_mainContent_DropDownListCurrency" class="valid"></select>
				//We are going to handle a dropdown with the nature of select--> means it is a static dropdown
				Select dropdown= new Select(staticdropdown);
				
				Thread.sleep(1000);
				
				//Selecting the value in the dropdown on the basis of index 
				dropdown.selectByIndex(3);       //USD
				System.out.println(dropdown.getFirstSelectedOption().getText()); //It will print the selected option i.e. USD
				//To check checkbox is selected or not
				//<input id="ctl00_mainContent_chk_friendsandfamily" type="checkbox" name="ctl00$mainContent$chk_friendsandfamily">
				driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
				
				Thread.sleep(2000);				
				//To click on search button
				//<input type="submit" name="ctl00$mainContent$btn_FindFlights" value="Search" id="ctl00_mainContent_btn_FindFlights">
				driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
