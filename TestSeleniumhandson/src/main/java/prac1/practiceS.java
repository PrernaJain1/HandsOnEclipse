package prac1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class practiceS {
	WebDriver driver;
	String excelPath="/home/pg_user/Desktop/AdditionalSuppliedFiles/Data.xls";

	@BeforeClass
	public void Setup() {
		System.setProperty("webdriver.gecko.driver","/dome/pg_user/Desktop/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/application/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

	}
	@Test(priority = 1)
	public void test1() throws EncryptedDocumentException, IOException {
		driver.findElement(By.id("Add member")).click();

		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheetAt(0);

		for(int i=1;i<=sheet.getLastRowNum();i++) {
		Row row = sheet.getRow(i);
		String firstname = row.getCell(0).getStringCellValue();
		String lastName = row.getCell(1).getStringCellValue();
		String email = row.getCell(2).getStringCellValue();
		String employeeNumber =row.getCell(3).getStringCellValue();
		String stream = row.getCell(4).getStringCellValue();

		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("employeeNumber")).sendKeys(employeeNumber);
		driver.findElement(By.id("stream")).sendKeys(stream);
		driver.findElement(By.id("female")).click();
		driver.findElement(By.id("add member")).click();

		String msg = driver.findElement(By.id("msg")).getText();
		row.createCell(5).setCellValue(msg);

		}
		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		workbook.close();

		driver.findElement(By.linkText("Home"));

	}

	@Test(priority = 2)
	@Parameters({"type","pswd"})
	public void test2(String user,String password) {
		driver.findElement(By.id("AlreadyMember")).click();

		driver.findElement(By.id("type")).sendKeys(user);
		driver.findElement(By.id("pswd")).sendKeys(password);

		SoftAssert sa= new SoftAssert();
		sa.assertTrue(driver.findElement(By.linkText("SignOutLink")).isDisplayed());
		sa.assertAll();
	}

	@DataProvider(name="provide")
	public Object[][] dataProvide(){
		return new Object[][] {
			{"Selenium Using Python", "Educator"},
			{"Agile Testing","Co-Educator"}
		};
	}

	@Test(priority =3, dataProvider = "provide")
	public void test3(String Course, String Role) {
		driver.findElement(By.id("selectCourse")).sendKeys(Course);
		driver.findElement(By.id("Role")).sendKeys(Role);
		driver.findElement(By.id("Add course")).click();
	}

	@AfterClass
	public void tearDown() {
		//Click on sign out link
		driver.findElement(By.id("SignOut")).click();

		if(driver!=null) {
			driver.quit();
		}
	}

}
