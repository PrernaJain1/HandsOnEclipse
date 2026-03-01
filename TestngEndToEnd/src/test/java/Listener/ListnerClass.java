package Listener;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import TestNG.CricBuzz;

public class ListnerClass extends CricBuzz implements ITestListener{
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ss=(TakesScreenshot)driver;
		File f=ss.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(f, new File("C:\\Users\\91914\\eclipse-workspace\\TestngEndToEnd\\Screenshots\\"+ result.getName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
