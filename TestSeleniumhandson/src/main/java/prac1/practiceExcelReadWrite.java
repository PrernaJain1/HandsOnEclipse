package prac1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class practiceExcelReadWrite {

	WebDriver driver;
	String excelPath ="C:\\Users\\91914\\Downloads\\ExcelReadWrite.xlsx";

	@BeforeClass
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws EncryptedDocumentException, IOException, InterruptedException {
		System.out.println("Reading data from excel");
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Details");
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			String name = row.getCell(0).getStringCellValue();
			String email = row.getCell(1).getStringCellValue();
			System.out.println("Name fetched from excel :"+ name);
			System.out.println("Email fetched from excel : "+ email);
			driver.findElement(By.id("userName")).sendKeys(name);
			driver.findElement(By.id("userEmail")).sendKeys(email);
			row.createCell(2).setCellValue("5");

			Thread.sleep(5000);
		}
		System.out.println("Writing data into excel");
		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		workbook.close();

	}

	@AfterClass
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
