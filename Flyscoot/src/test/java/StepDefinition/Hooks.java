package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	/*
	 * @Before public void beforeScenario(Scenario scenario) {
	 * Reporter.assignAuthor("Automated by - Nidhi"); }
	 * 
	 * @After public void afterScenario(Scenario scenario) { if
	 * (scenario.isFailed()) {
	 * 
	 * try { File sourcePath = ((TakesScreenshot)
	 * Steps.driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * File destinationPath = new File(System.getProperty("user.dir") +
	 * "/target/cucumber-reports/screenshots/" + getcurrentdateandtime()+ ".png");
	 * 
	 * Files.copy(sourcePath, destinationPath);
	 * 
	 * Reporter.addScreenCaptureFromPath(destinationPath.toString()); } catch
	 * (IOException e) { } }
	 * 
	 * if (!scenario.isFailed()) {
	 * 
	 * try { File sourcePath = ((TakesScreenshot)
	 * Steps.driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * File destinationPath = new File(System.getProperty("user.dir") +
	 * "/target/cucumber-reports/screenshots/" + getcurrentdateandtime()+ ".png");
	 * 
	 * Files.copy(sourcePath, destinationPath);
	 * 
	 * Reporter.addScreenCaptureFromPath(destinationPath.toString()); } catch
	 * (IOException e) { } }
	 * 
	 * } public static String getcurrentdateandtime(){ String str = null; try{
	 * DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS"); Date
	 * date = new Date(); //current system date time str= dateFormat.format(date);
	 * str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", ""); }
	 * catch(Exception E) { E.printStackTrace(); } return str; }
	 */

}
