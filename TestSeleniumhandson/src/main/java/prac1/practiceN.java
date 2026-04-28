package prac1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class practiceN {
	WebDriver driver;
	String excelPath ="/home/pg_user/Desktop/AdditionalSuppliedFiles/Data.xls";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "/home/pg_user/Desktop/geckodriver");
		driver= new FirefoxDriver();
		driver.get("http://localhost:8080/application/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority=1)
	public void test1() throws EncryptedDocumentException, IOException {
		driver.findElement(By.id("RegisterNow")).click();

		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Details");

		for(int i=1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			String name = row.getCell(0).getStringCellValue();
			String email = row.getCell(1).getStringCellValue();

			driver.findElement(By.id("name")).sendKeys(name);
			driver.findElement(By.id("emailid")).sendKeys(email);

			driver.findElement(By.id("Register")).click();
			String msg = driver.findElement(By.id("message")).getText();
			row.createCell(row.getLastCellNum()).setCellValue(msg);

			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("/home/pg_user/Desktop/AdditionalSuppliedFiles/Screenshots/"+ name +".png"));

			driver.findElement(By.id("Reset")).click();
		}
		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		workbook.close();

		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.id("username")).sendKeys("librarian");
		driver.findElement(By.id("Password")).sendKeys("Infy123");

	}

	@DataProvider(name = "bookDetails")
	public Object[][] bookDetailsProvide(){
		return new Object[][] {
			{"Lord of the Rings", "000747766"},
			{"The Alchemist", "1112234988"}
		};
	}

	@Test(priority=2, dataProvider = "bookDetails")
	public void test2(String bookName, String ISBN) {
		driver.findElement(By.id("BookDetails")).click();

		Select s = new Select(driver.findElement(By.id("category")));
		s.selectByVisibleText("Fiction");
		System.out.print(bookName +" "+ ISBN);

		//Web table
		boolean found = false;
		int i=1;
		List<WebElement> bookname = driver.findElements(By.xpath("//tbody//tr//td[1]"));

		for(WebElement bn:bookname) {
			if(bn.getText().equals(bookName)) {
				String isbn= driver.findElement(By.xpath("(//tbody//tr//td[2])["+i+"]")).getText();
				if(isbn.equals(ISBN)) {
					System.out.print(driver.findElement(By.xpath("(//tbody//tr//td[3])["+i+"]")));
					found =true;
					break;
				}
			}
			i++;
		}

		if(!found) {
			System.out.println("Book is not available");
		}

		driver.navigate().refresh();
	}

	@Test(priority=3)
	public void test3() {
		driver.findElement(By.linkText("add a book")).click();
		driver.findElement(By.id("BookType")).sendKeys("Non Fiction");
		driver.findElement(By.id("Title")).sendKeys("What Happened");
		driver.findElement(By.id("ISBN")).sendKeys("122228-99");
		driver.findElement(By.id("AuthorName")).sendKeys("Hillary");

		Alert a = driver.switchTo().alert();
		String text = a.getText();
		SoftAssert sa = new SoftAssert();
		try {
			sa.assertEquals(text, "Book successfully added");
		}catch(Exception E) {
			System.out.println("Assertion failed but continuing");
		}
		sa.assertAll();
		a.accept();
	}

	@AfterClass
	public void afterClass() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
