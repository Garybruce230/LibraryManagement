package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.StartPagePO;
import pages.LoginPagePO;
import utils.WebDriverManager;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import pages.DashboardPagePO;
import pages.AddBookPagePO;

import java.util.Map;

public class StartPageSteps {

        WebDriverManager webDriverManager = new WebDriverManager();
        WebDriver driver;
        ConfigReader configReader = new ConfigReader();
        StartPagePO landingPage;
        LoginPagePO loginPage;
        DashboardPagePO dashboardPagePO;
        AddBookPagePO addBookPage;
    private Map<String, Object> testCases;

    public StartPageSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        landingPage = new StartPagePO(driver);
        loginPage = new LoginPagePO(driver);
        dashboardPagePO = new DashboardPagePO(driver);
        addBookPage = new AddBookPagePO(driver);
    }


        @Given("I am on the landing page")
        public void i_am_on_the_landing_page() {
            driver.get(configReader.getWebsiteURL());

            Assert.assertEquals("Exercise1: UI Application", landingPage.returnH1Content());
            Assert.assertEquals("Task", landingPage.returnTaskContent());
            Assert.assertEquals("Important Guidelines", landingPage.returnImportantGuidelinesHeading());
            Assert.assertEquals("Business Requirement", landingPage.returnBusinessReqeuestHeading());
            Assert.assertEquals("Introduction", landingPage.retunrInductionHeading());
            Assert.assertEquals("Start Testing", landingPage.startButtonText());


        }


    @Given("I am validating content of the page")
    public void landing_page_content_check() {

        Assert.assertEquals("Start Testing", landingPage.startButtonText());
       // landingPage.clickStartNow();
       // Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Given("I click on Start button on landing page")
    public void clickStartTestingButtonL() {

        landingPage.clickStartNow();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Given("I should see Login page")
    public void checkLoginPageURL() {


         Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }





    @When("I log in with credentials {string} and {string}")
        public void iLogInWithCredentialsAnd(String login, String passwod) {

            Assert.assertEquals("Log In", landingPage.startButtonText());
            loginPage.enterId(login);
            loginPage.enterPassword(passwod);
            loginPage.clickLoginButton();

        }



        @Then("I am on the dashboard")
        public void i_am_on_the_dashboard () {
        Assert.assertEquals("Welcome, Admin!", loginPage.returnHeadingText());

        }

}

