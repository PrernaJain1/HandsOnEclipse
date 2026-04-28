package demoqa;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ElementsUploadAndDownload {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");

		Thread.sleep(2000);
		driver.findElement(By.id("downloadButton")).click();
		Thread.sleep(7000);

		String downloadPath ="C:\\Users\\91914\\Downloads\\";
		File folder = new File(downloadPath);
		File[] listOfFiles = folder.listFiles();

		for(File file:listOfFiles) {
			if(file.getName().equalsIgnoreCase("sampleFile.jpeg")) {
				System.out.println("File downloaded successfully");
				break;
			}
		}
		Thread.sleep(5000);
		File f = new File(downloadPath+ "\\sampleFile.jpeg");
		boolean deleted = f.delete();
		if(deleted) {
			System.out.println("File deleted successfully");
		}else {
			System.out.println("Unable to delete the file");
		}

		Thread.sleep(5000);
		//Uploading file
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\91914\\Downloads\\Sunflower.jfif");
		System.out.println(driver.findElement(By.id("uploadedFilePath")).getText());
		System.out.println("File uploaded successfully");
		Thread.sleep(5000);
		driver.quit();
	}

}
