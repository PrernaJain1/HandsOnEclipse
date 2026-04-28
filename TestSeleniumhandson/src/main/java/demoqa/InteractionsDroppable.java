package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class InteractionsDroppable {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable");
		Thread.sleep(5000);

		//Simple - method 1
		WebElement dragMe = driver.findElement(By.id("draggable"));
		WebElement dropHere = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.clickAndHold(dragMe).moveToElement(dropHere).release().build().perform();
		System.out.println("Simple drag drop done!");
		System.out.println("Dropped Done: "+dropHere.getText().equals("Dropped!"));
		Thread.sleep(2000);

		//Accept - through method 2
		driver.findElement(By.id("droppableExample-tab-accept")).click();
		WebElement notAcceptable = driver.findElement(By.xpath("//div[text()='Not Acceptable']")) ;
		WebElement dropHere1 = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[contains(@class,'ui-droppable')]"));
		Actions a1 = new Actions(driver);
		a1.dragAndDrop(notAcceptable, dropHere1).build().perform();
		System.out.println("Not Accept drag drop done!");
		System.out.println("Not Accepted! " + dropHere1.getText().equals("Drop here"));
		Thread.sleep(2000);

		//Prevent Propagation method 3
		driver.findElement(By.id("droppableExample-tab-preventPropogation")).click();
		WebElement dragMeProp = driver.findElement(By.id("dragBox"));
		WebElement outerDroppable = driver.findElement(By.id("notGreedyDropBox"));
		WebElement outerDroppableText = driver.findElement(By.xpath("(//p[text()='Outer droppable'])[1]"));
		WebElement innerDroppableText = driver.findElement(By.xpath("(//p[text()='Inner droppable (not greedy)'])[1]"));
		Actions a2 = new Actions(driver);

		a2.moveToElement(dragMeProp).clickAndHold().moveToElement(outerDroppable).release().build().perform();
		System.out.println("Prevent Propagation drag drop done");
		Thread.sleep(2000);
		System.out.println("Outer drop: "+ outerDroppableText.getText().equals("Dropped!"));
		System.out.println("Inner drop: " + innerDroppableText.getText().equals("Dropped!"));
		Thread.sleep(2000);

		//Revert Drag
		driver.findElement(By.id("droppableExample-tab-revertable")).click();
		Thread.sleep(2000);
		WebElement willRevert = driver.findElement(By.xpath("//div[@class=\"revertable-drop-container\"]//div[@id='revertable']"));
		WebElement notRevert = driver.findElement(By.xpath("//div[@class=\"revertable-drop-container\"]//div[@id='notRevertable']"));
		WebElement dropHereRevert = driver.findElement(By.xpath("//div[@class='revertable-drop-container']//div[contains(@class,'ui-droppable')]"));
		//Finding initial position of both the elements
		Point revStartPos = willRevert.getLocation();
		Point notRevStartPos = notRevert.getLocation();
		System.out.println("Revert position" + revStartPos);
		System.out.println("Not revert position" +notRevStartPos);
		//drag and drop
		Actions a4 = new Actions(driver);
		a4.dragAndDrop(willRevert, dropHereRevert).build().perform();
		a4.dragAndDrop(notRevert, dropHereRevert).build().perform();
		System.out.println("Revert drag drop done!");
		Thread.sleep(5000);
		//Finding after position of both elements
		Point revEndPos = willRevert.getLocation();
		Point notRevEndPos = notRevert.getLocation();
		if(revStartPos.equals(revEndPos)) {
			System.out.println("Position not changed for revert");
		}else {
			System.out.println("Position changed for revert");
		}
		if(notRevStartPos.equals(notRevEndPos)) {
			System.out.println("Position not changed for not revert");
		}else {
			System.out.println("Position changed for not revert");
		}
		Thread.sleep(2000);

		driver.quit();
	}
}
