package prac1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class practiceMe {

	WebDriver driver;
	String excelPath="C:\\Users\\91914\\Downloads\\WebTable.xlsx";

	@BeforeClass
	public void setUp() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/webtables");
		Thread.sleep(2000);
	}

	@Test
	public void locations() throws IOException {
		//iterate through the displayed web table
		//fetch the header names from details sheet of locations.xls
		//if the address start with c or g,
		//update all those identified rows from web table to respective columns in excel.
		int i=1;
//		List<WebElement> rowWebTable = driver.findElements(By.tagName("tr"));
		List<WebElement> nameWebTable= driver.findElements(By.xpath("//tr//td[1]"));
		for(WebElement name:nameWebTable) {
			if(name.getText().startsWith("C") || name.getText().startsWith("K")) {
				System.out.println(name.getText());
				System.out.println(driver.findElements(By.tagName("tr")).get(i));
			}
			i++;
		}

//		FileInputStream fis = new FileInputStream(excelPath);
//		Workbook workbook = WorkbookFactory.create(fis);
//		Sheet sheet = workbook.getSheet("Details");
//		Row headerRow = sheet.getRow(0);
//		System.out.println(headerRow);


	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
