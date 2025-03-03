package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AddBookPagePO;
import pages.DashboardPagePO;
import pages.StartPagePO;
import pages.LoginPagePO;
import utils.ConfigReader;
import utils.JsonDataReader;
import utils.WebDriverManager;

import java.io.IOException;
import java.util.Map;

public class LognPageSteps {
    WebDriverManager webDriverManager = new WebDriverManager();
    WebDriver driver;
    ConfigReader configReader = new ConfigReader();
    StartPagePO startPagePO;
    LoginPagePO loginPagePO;
    DashboardPagePO dashboardPage;
    AddBookPagePO addBookPagePO;

    String testCase;

    private Map<String, Object> testCases;

    public LognPageSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        startPagePO = new StartPagePO(driver);
        loginPagePO = new LoginPagePO(driver);
        dashboardPage = new DashboardPagePO(driver);
        addBookPagePO = new AddBookPagePO(driver);
    }



    @When("I log in with credentials {string} credentials")
    public void iLogInWithCredentialsCredentials(String testCaseIdentifier) throws IOException {
        testCases = JsonDataReader.readJsonFile();
        Map<String, Object> userData = (Map<String, Object>) testCases.get(testCaseIdentifier);
        testCase=testCaseIdentifier;
        if (userData != null) {
            String username = (String) userData.get("username");
            String password = (String) userData.get("password");
            loginPagePO.enterId(username);
            loginPagePO.enterPassword(password);
            Assert.assertEquals("Log In", startPagePO.startButtonText());
            loginPagePO.clickLoginButton();

            // Use the username and password in your test steps
            System.out.println("Running test: " + testCaseIdentifier + " with username: " + username + " and password: " + password);
        } else {
            System.out.println("Test case not found: " + testCaseIdentifier);
        }


    }

    @Then("I should see error message {string} and {string} and {string} on Login page")
    public void iShouldSeeErrorMessageOnLoginPage(String errorTitle,String errorMessage ,String errorMessageTwo) {

         if (testCase=="MissingUserPassword") {
             Assert.assertEquals(errorTitle, loginPagePO.returnErrorTitle());
             Assert.assertEquals(errorMessage, loginPagePO.returnErrorMessageOne());
             Assert.assertEquals(errorMessageTwo, loginPagePO.returnErrorMessageTwo());

         }else
        {
            Assert.assertEquals(errorTitle, loginPagePO.returnErrorTitle());
            Assert.assertEquals(errorMessage, loginPagePO.returnErrorMessageOne());

        }


    }

}
