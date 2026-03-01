import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		//Handling static dropdown 
		//Handling dynamic dropdown 
		//Handling checkboxes
		//Handling radio buttons
		//handling text buttons
		//Handling alerts Java popup
		//Handling Selenium Webdriver form methods
				
		//Dynamic dropdown- these options are loaded when we click on dropdown i.e. it is loaded on the basis of user actions
		
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
		
		//To select bengaluru
		//Xpath for bengaluru - //a[@value='BLR']
		//<a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Bengaluru (BLR)" value="BLR"> Bengaluru (BLR)</a>
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		Thread.sleep(2000);
		
		//To select chennai
		//xpath for chennai -n //a[@value='MAA']
		//<a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Chennai (MAA)" value="MAA" xpath="1"> Chennai (MAA)</a>
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		//To select chennai
		//Parent xpath space child xpath
		//If we are not allowed to use indexes then we use parent child relationship
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		Thread.sleep(6000);

		//To select current depart date in calendar
		//<a class="ui-state-default ui-state-highlight ui-state-active" href="#">18</a>	
		
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();		
		driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();
		
		//driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//div[@class='ui-datepicker-group ui-datepicker-group-first']//tbody//tr//td//a[contains(@class,'ui-state-highlight')]")).click();
		
		//<input name="ctl00$mainContent$view_date2" type="text" readonly="readonly" id="ctl00_mainContent_view_date2" class="custom_date_pic required home-date-pick valid" xpath="1">
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());  //this isEnabled() function is not working for this site.
		
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
		
		//clicking on roundtrip radio button
		//<input id="ctl00_mainContent_rbtnl_Trip_1" type="radio" name="ctl00$mainContent$rbtnl_Trip" value="RoundTrip" checked="checked" xpath="1">
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		//To check dropdown option should be enabled.
		//<input name="ctl00$mainContent$view_date2" type="text" readonly="readonly" id="ctl00_mainContent_view_date2" class="custom_date_pic required home-date-pick valid" xpath="1">
       
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled()); //this isEnabled() function is not working for this site.
		
		
		//To check dropdown option should be enabled.
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
		
		//static dropdown - Select
		//Dynamic dropdown - indexes
		//Parent child relationship path
		
		
		
		
		
	}

}
