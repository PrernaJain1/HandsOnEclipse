package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ElementsTextBox {

	public static void main(String[] args) throws InterruptedException {
		//Disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");

		//Open browser and maximize window
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		//Navigating to a page
		driver.navigate().to("https://youtube.com");

		//Refresh the page
		driver.navigate().refresh();

		driver.get("https://demoqa.com/elements");

		//Navigate back
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("Navigating back to youtube");

		//Navigate forward
		driver.navigate().forward();
		Thread.sleep(2000);
		System.out.println("Navigation Forward to demo qa");

		//Remove ads - Java script
		Thread.sleep(2000);
		JavascriptExecutor script = (JavascriptExecutor)driver;
		script.executeScript("document.querySelectorAll('iframe').forEach(el => el.remove());");
		System.out.println("Removed Ads");
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//Navigate to text box page
		WebElement textbox = driver.findElement(By.xpath("//span[text() ='Text Box']"));
		textbox.click();
		System.out.println("Clicked on text box");

		//enter name (tagname#id)
		driver.findElement(By.cssSelector("input#userName")).sendKeys("Prerna");

		//Enter email (#id)
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("pj@gmail.com");

		//Enter address
		driver.findElement(By.cssSelector("textarea#currentAddress")).sendKeys("abc");
		driver.findElement(By.cssSelector("textarea[id='permanentAddress']")).sendKeys("xyz");
		System.out.println("Details Entered");

		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.id("submit"));
		//Scroll to submit button
		//script.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//script.executeScript("arguments[0].scrollIntoView(true);", submit);
		script.executeScript("arguments[0].scrollIntoView({block: 'center'});",submit);
		System.out.println("Scrolling done");
		//Click on submit
		script.executeScript("arguments[0].click();", submit);
		System.out.print("Clicked on submit button");

		Thread.sleep(5000);
		driver.quit();

	}

}
