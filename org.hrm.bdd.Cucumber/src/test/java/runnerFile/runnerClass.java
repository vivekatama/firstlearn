package runnerFile;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(features = ".\\src\\test\\java\\featureFiles\\LoginFeatureMaps.feature", 
glue = "stepDefinationFile",dryRun = false)


public class runnerClass extends AbstractTestNGCucumberTests{

}
