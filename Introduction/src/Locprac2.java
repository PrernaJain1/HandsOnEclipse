import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locprac2 {

	public static void main(String[] args) {
		
	//First invoke chrome browser
		
		//For allowing url to hit on browser
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
					
		//invoke browser
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\91914\\Desktop\\chrome_driver_113_version\\chromedriver.exe");	
			WebDriver driver= new ChromeDriver(options);
					
		//browser url
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
			//relative xpath
			//In this u start from anywhere in the middle traversing to the child object ...not from the root object)
			//In this we use double slash //		
			
			//absolute xpath (U will start from top ie from root object and traversing to the child object )
			//In absolute xpath u use single slash /
			
			//mainly we use relative xpath bcoz in absolute xpath there is a chance of breaking something in the middle
	
		/*<header class="jumbotron text-center header_style" style="">
		      <a href="https://www.rahulshettyacademy.com/"><img src="images/rs_logo.png" class="logoClass"></a>
			  <a href="https://rahulshettyacademy.com/documents-request" class="blinkingText">Free Access to InterviewQues/ResumeAssistance/Material</a>
		      <div style="text-align: right;margin-top: -30px;">
		          <a href="https://www.rahulshettyacademy.com/"><button class="btn btn-primary">Home</button></a>
		          <button class="btn btn-primary">Practice</button>	
		          <button class="btn btn-primary">Login</button>
		          <button class="btn btn-primary">Signup</button>
		      </div>
		</header>*/
		
		//Parent to child traverse (relative traverse)
		//	//header/div/button[1]              ..........point to Practice button
			System.out.println(driver.findElement(By.xpath("//header/div/button[1]")).getText());
		
		//Child to child traverse
		//   //header/div/button[1]/following-sibling::button[1]          ..............point to Login button
			System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
			
		//sibling(Child) to parent traverse....point to Login button
			System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
			
		//sibling(Child) to parent traverse....point to header button
			System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header")).getText());
			
		driver.close();
	}

}
