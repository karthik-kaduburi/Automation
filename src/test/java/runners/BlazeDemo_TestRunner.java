package runners;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = { "src/test/resources/FeatureFiles" }, glue = { "steps" }, tags = "@flight-booking", monochrome = true, plugin = {
		"html:target/cucumber-html-report/cucumber.html", "json:target/cucumber-reports/cucumber.json",
		"junit:target/cucumber-reports/cucumber.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })


public class BlazeDemo_TestRunner  extends AbstractTestNGCucumberTests  {
	
	
}


