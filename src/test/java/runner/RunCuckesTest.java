package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(	
	tags= {"@sample"},	
	features=".",
	glue= {"steps"},
	plugin= {"pretty","html:target/html/", "json:target/json/single.json" , "rerun:target/rerun/rerun.txt","junit:target/junit/junit.xml"}		
)
//
public class RunCuckesTest {}
