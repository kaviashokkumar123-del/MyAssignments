package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src/test/java/feature",
glue={"stepdefinition", "HooksImplementation"},
publish=true)
public class RunnerCucumber extends AbstractTestNGCucumberTests{

}
