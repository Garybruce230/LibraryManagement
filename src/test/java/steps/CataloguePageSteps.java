package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AddBookPagePO;
import pages.DashboardPagePO;
import pages.StartPagePO;
import pages.LoginPagePO;
import utils.ConfigReader;
import utils.WebDriverManager;

import java.util.Map;

public class CataloguePageSteps {

    WebDriverManager webDriverManager = new WebDriverManager();
    WebDriver driver;
    ConfigReader configReader = new ConfigReader();
    StartPagePO startPagePO;
    LoginPagePO loginPagePO;
    DashboardPagePO dashboardPagePO;
    AddBookPagePO addBookPagePO;

    private Map<String, Object> testCases;

    public CataloguePageSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        startPagePO = new StartPagePO(driver);
        loginPagePO = new LoginPagePO(driver);
        dashboardPagePO = new DashboardPagePO(driver);
        addBookPagePO = new AddBookPagePO(driver);
    }


    @And("I am validating content and Books present on catalogue should be {int}")
    public void iAmValidatingContentAndBooksPresentOnCatalogue(int booksCount) {
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/books"));
        Assert.assertEquals("Welcome, Admin!", loginPagePO.returnHeadingText());
        Assert.assertEquals("Book List", dashboardPagePO.returnBookPageTitle());
        Assert.assertEquals("Validating Books are available on login",booksCount , dashboardPagePO.getBookCount());

    }


    @Then("I delete first book")
    public void iDeleteFirstBook() {

        dashboardPagePO.deleteBook();
    }

    @Then("I click on logout button")
    public void iClickOnLogoutButton() {
        dashboardPagePO.logout();
    }

    @And("I click on Add Book button")
    public void iClickOnAddBookButton() {
        dashboardPagePO.addBook();
    }


}
