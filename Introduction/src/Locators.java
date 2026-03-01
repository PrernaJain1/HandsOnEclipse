import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		// series of steps
		String name="Rahul";
	//First invoke chrome browser
		
		//For allowing url to hit on browser
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
				
		//invoke browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver= new ChromeDriver(options);
				
		//browser url
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
	//Implicit wait	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	//ID Locator
		
		//<input type="text" placeholder="Username" id="inputUsername" value="">
		driver.findElement(By.id("inputUsername")).sendKeys("Prerna");
		
	//name Locator
		
		//<input type="password" placeholder="Password" name="inputPassword" value="">
		driver.findElement(By.name("inputPassword")).sendKeys("1234");
		
	//Class name Locator
		
		//<button class="submit signInBtn" type="submit">Sign In</button>
		driver.findElement(By.className("signInBtn")).click();
		
	//Link Text locator
		
		//<a href="#">Forgot your password?</a>
		driver.findElement(By.linkText("Forgot your password?")).click();
		
	//CSS selector
		
		//if you have classname -> tagname.classname	
		//<p class="error">* Incorrect username or password </p>
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		
		//if you have classname -> .classname
		//<button class="reset-pwd-btn">Reset Login</button>
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//if you have id -> tagname#id	
		//<input type="text" placeholder="Username" id="inputUsername" value="">
		//driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Rahul");.....here Rahul is hard codded.
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		
		//generic syntax or customized syntax  -> tagname[attribute='value']
		//<input type="text" placeholder="Email">
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jain.p@gmail.com");
		
		//another syntax ->  Tagname[attribute=’value’]:nth-child(index). -  Child items
		//<input type="text" placeholder="Email">
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abc@gmail.com");
		
		//Parenttagname childtagname
		//<p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
		
		String msg= driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(msg);
		
		//<input type="password" placeholder="Password" name="inputPassword" value="">
		//tagname[atributte*='pass'] here * represents regular expression i.e...here pass is static and we don't know what is there after it ..
		//It will scan all type attributes which have pass in it..
		
		String password= getPassword(msg);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
	
			
	//X-path
		
		//generic syntax -> //tagname[@attribute='value']
		//<input type="text" placeholder="Name">
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Prerna");
		
		//second syntax ->  //tagname[@attribute='value'][index]
		//<input type="text" placeholder="Email">
		//To clear all the data in a text box of email
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//third syntax->   //parentTagname/childTagname
		//<form><input type="text" placeholder="Phone Number"></form>
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("123445678");
		
		//sign in button
		//Regular expression by X-path   -> //tagname[contains(@attribute,'value')]. 
		//<button class="submit signInBtn" type="submit">Sign In</button>  
		driver.findElement(By.xpath("//button[contains(@class,'submit signInBtn')]")).click();
		
		//for logout button
		//<button class="logout-btn">Log Out</button>
		//Or    //*[text()='Log Out']
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		
		Thread.sleep(1000);
		
	//Tag name 
		//Generally not used bcoz in a page there can be multiple tag names
		//<p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;">You are successfully logged in.</p>
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		
		//to check whatever text extracted from browser is same as that of required one
		//testng framework will give us assertions
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		
		//validating greeting message
		//<div class="login-container"><h2>Hello Rahul,</h2><h1>Welcome to <strong style="color: rgb(255, 75, 43);">Rahul Shetty </strong>Academy</h1><p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;">You are successfully logged in.</p><button class="logout-btn">Log Out</button></div>
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+ name+ ",");
		

	//To close browser
		driver.close();
	}
	
	private static String getPassword(String msg) {
		//msg----->Please use temporary password 'rahulshettyacademy' to Login.
		
		String[] passwordArray = msg.split("'");
		//0th index--->Please use temporary password 
		//1th index--->rahulshettyacademy' to Login.
		
		String password= passwordArray[1].split("'")[0];
		//0th-->rahulshettyacademy
		//1th--> to Login.
		
		return password;
	}
}
