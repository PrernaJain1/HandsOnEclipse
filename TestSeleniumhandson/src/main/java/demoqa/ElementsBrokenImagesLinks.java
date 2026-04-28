package demoqa;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsBrokenImagesLinks {

	public static void main(String[] args) throws IOException {
		//Broken Images:::::::::
		//Locate all <img> tags
		//Get the src attribute
		//Send HTTP request
		//Check response code

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/broken");
		//waiting for page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Broken Links - Images']")));
		//Locate all <img> tags
		List<WebElement> images = driver.findElements(By.tagName("img"));
		//Get the src attribute
		for(WebElement img: images) {
			String imgUrl = img.getAttribute("src");
			System.out.println("Image Url : " + imgUrl);
			//Send HTTP request
			URL url = new URL(imgUrl);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			//Check response code
			int responseCode = connection.getResponseCode();
			//Checking if image is displayed or not
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Boolean imageDisplayed = (Boolean) js.executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0", img);

			if(responseCode<400 && imageDisplayed) {
				System.out.println("Valid Image");
			}
			else {
				System.out.println("Broken Image");
			}
		}

		//Broken Link:::::::
		//Locate <a> tags
		//Get href
		//Send HTTP request
		//Verify status code

		//Locate <a> tags
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement l:links) {
			//Get href
			String linkUrl = l.getAttribute("href");
			//Send HTTP request
			URL url = new URL(linkUrl);
			HttpURLConnection connection1 = (HttpURLConnection)url.openConnection();
			//Verify status code
			int response = connection1.getResponseCode();
			if(response<400) {
				System.out.println("Valid Link");
			}
			else {
				System.out.println("Broken Link");
			}
		}
		driver.quit();
	}
}
