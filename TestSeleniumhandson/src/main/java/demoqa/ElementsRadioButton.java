package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ElementsRadioButton {

	public static void main(String[] args) throws InterruptedException {
		//isSelected(), isEnabled(), isDisplayed()..
		//following-sibling::labelname
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demoqa.com/elements");

		driver.manage().window().maximize();

		//click on radio button text to open page
		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();

		//To check if radio button is enabled
		WebElement yesButton= driver.findElement(By.xpath("//input[@id ='yesRadio']"));
		Assert.assertTrue(yesButton.isDisplayed(),"Button is not displayed");
		System.out.println("Yes Button is displayed");
		
		//Click on Impressive button
		WebElement impressiveButton = driver.findElement(By.xpath("(//input[contains(@class, 'form-check-input')])[2]/following-sibling::label"));
		Assert.assertFalse(impressiveButton.isSelected(),"Expected Button to be UnSelected");
		System.out.println("Button is UnSelected");
		Thread.sleep(2000);
		impressiveButton.click();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(impressiveButton.getText(), "abc");
		sa.assertAll();
		System.out.println("Clicked on Impressive button");
		Thread.sleep(3000);

		//Check if No button is disabled
		WebElement noButton = driver.findElement(By.xpath("(//input[contains(@class, 'disabled')])"));
		Assert.assertFalse(noButton.isEnabled(),"Expected No button to be disabled");
		System.out.println("No button is not enabled");
		Thread.sleep(2000);

		driver.quit();
	}

}
