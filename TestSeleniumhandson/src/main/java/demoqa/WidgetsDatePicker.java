package demoqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class WidgetsDatePicker {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/date-picker");

		Thread.sleep(2000);
		//Clicked on select date drop down
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		//Selecting month - Select Class
		WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
		Select s = new Select(month);
		s.selectByVisibleText("June");
		//Selecting year - Select Class
		WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
		Select s1 = new Select(year);
		s1.selectByValue("2015");
		Thread.sleep(3000);
		//Selecting date
//		WebElement outsideMonth = driver.findElement(By.xpath("//div[contains(@class,'outside')]"));
		List<WebElement> allDates = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day')]"));

		for(WebElement monthDates:allDates) {
			if(!monthDates.getAttribute("class").contains("outside")) {
				if(monthDates.getText().equals("25")) {
					monthDates.click();
					break;
				}
			}
		}
		System.out.println("Date and year selected");
		Thread.sleep(2000);
		//Select Time
		driver.findElement(By.id("dateAndTimePickerInput")).click();
		List<WebElement> allTimes= driver.findElements(By.xpath("//li[contains(@class,'react-datepicker__time-list-item ')]"));
		for(WebElement time:allTimes) {
			if(time.getText().equals("01:00")) {
				time.click();
				break;
			}
		}
		System.out.println("Time Selected");
		Thread.sleep(2000);
		driver.quit();
	}
}
