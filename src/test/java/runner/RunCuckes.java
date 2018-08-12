package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(	
	tags= {"@sample"},	
	features=".",
	glue= {"steps"},
	plugin= {"pretty","html:target/htmlreports" }		
)
public class RunCuckes {}
