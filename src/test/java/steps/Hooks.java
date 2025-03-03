package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.WebDriverManager;

public class Hooks {
    private WebDriverManager webDriverManager;
    private WebDriver driver;

    private ConfigReader configReader;

    public Hooks(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    @Before
    public void setUp(Scenario scenario) {
        driver = webDriverManager.getDriver();

    }

    @After
    public void tearDown() {
        webDriverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
