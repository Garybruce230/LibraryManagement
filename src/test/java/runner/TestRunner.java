package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "steps",
        plugin = {"pretty", "html:target/libraryBookManagement-reports.html", "json:target/cucumber.json"},
        monochrome = true,
        tags = "@Regression"
)
public class TestRunner {
    static WebDriverManager webDriverManager = new WebDriverManager();

    @AfterClass
    public static void tearDown() {
        webDriverManager.quitDriver();
    }
}
