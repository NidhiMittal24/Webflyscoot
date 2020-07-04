package TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\nidhi_mittal\\eclipse-workspace\\Flyscoot\\src\\test\\java\\Features",
glue={"StepDefinition"}, //the path of the step definition files
format= {"pretty","html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
monochrome = true, //display the console output in a proper readable format
strict = true, //it will check if any step is not defined in step definition file
dryRun = true //to check the mapping is proper between feature file and step def file

)

public class Runner {
	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(getReportConfigPath()));
	 }
	
	
	public static String getReportConfigPath(){
	 String reportConfigPath = "C:\\Users\\nidhi_mittal\\eclipse-workspace\\Flyscoot\\src\\test\\java\\configs\\extent-config.xml";
	return reportConfigPath;
	 }
}
