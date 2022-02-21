package com.selenium.navegation.runner;


import com.selenium.navegation.utils.BaseDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import lombok.SneakyThrows;

@CucumberOptions(
        tags = "@all",
        glue = { "com.selenium.navegation.steps" },
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" },
        features = { "src/test/java/com/selenium/navegation/resources/feature/" },
        monochrome = false,
        dryRun = false
)
public class RunSuiteTest extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @SneakyThrows
    @BeforeClass( alwaysRun = true )
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner( this.getClass() );
    }

    @Test( groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios" )
    public void runScenario( PickleWrapper pickleWrapper, FeatureWrapper featureWrapper ) {
        testNGCucumberRunner.runScenario( pickleWrapper.getPickle() );
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass( alwaysRun = true )
    public void tearDownClass() {
        BaseDriver.killDriver();
    }

}
