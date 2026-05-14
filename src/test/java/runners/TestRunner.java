package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Feature/GoogleSearch.feature"}
,glue = "StepDefination",
monochrome = true,
dryRun = false,
plugin = {"pretty","html:target//htmlreportfile.html"})
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	
	

	}
	


