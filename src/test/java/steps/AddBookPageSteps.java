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
import utils.JsonDataReader;
import utils.WebDriverManager;

import java.io.IOException;
import java.util.Map;

public class AddBookPageSteps {
    WebDriverManager webDriverManager = new WebDriverManager();
    WebDriver driver;
    ConfigReader configReader = new ConfigReader();
    StartPagePO startPagePO;
    LoginPagePO loginPagePO;
    DashboardPagePO dashboardPagePO;
    AddBookPagePO addBookPagePO;

    private Map<String, Object> testCases;

    public AddBookPageSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        startPagePO = new StartPagePO(driver);
        loginPagePO = new LoginPagePO(driver);
        dashboardPagePO = new DashboardPagePO(driver);
        addBookPagePO = new AddBookPagePO(driver);
    }

    @Then("I navigated to Add book page and validate content")
    public void iNavigatedToAddBookPageAndValidateContent() {
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/add-book"));
    }


    @And("I added book details with {string}")
    public void iAddedBookDetailsWith(String testdata) throws IOException {
        testCases = JsonDataReader.readJsonFile();
        Map<String, Object> userData = (Map<String, Object>) testCases.get(testdata);
        if (userData != null) {
            String title = (String) userData.get("title");
            String author = (String) userData.get("author");
            String isbn = (String) userData.get("iSBN");
            String genre = (String) userData.get("genre");
            String publicationDate = (String) userData.get("publicationDate");
            String price = (String) userData.get("price");
            addBookPagePO.addBookDetails(title,author,genre,isbn,publicationDate,price);

            } else {
            System.out.println("Test data not found: " + testdata);
        }

    }

    @And("I click on Add Book button on add-book page")
    public void iClickOnAddBookButtonOnAddBookPage() {

        addBookPagePO.setAddBookButton();
    }

    @And("I added book details with {string} , {string} , {string} , {string} , {string} and {string}")
    public void iAddedBookDetailsWithAnd(String title, String author, String genre, String isbn, String publicationDate, String price) {


        addBookPagePO.addBookDetails(title,author,genre,isbn,publicationDate,price);

    }

    @And("I will get error message on the page {string} and {string},{string},{string},{string},{string} and {string}")
    public void iWillGetErrorMessageOnThePageAndAnd(String ErrorHeader, String Errone, String ErrTwo, String ErrThree, String ErrFour, String ErrFive, String ErrSix) {

       Assert.assertEquals(ErrorHeader, addBookPagePO.returnErrorHeader());
        Assert.assertTrue(Errone, addBookPagePO.returnTableOfErrors().contains("Title is required."));
        Assert.assertTrue(ErrTwo, addBookPagePO.returnTableOfErrors().contains("Author is required."));
        Assert.assertTrue(ErrThree, addBookPagePO.returnTableOfErrors().contains("Genre is required."));
        Assert.assertTrue(ErrFour, addBookPagePO.returnTableOfErrors().contains("ISBN is required."));
        Assert.assertTrue(ErrFive, addBookPagePO.returnTableOfErrors().contains("Publication Date is required."));
        Assert.assertTrue(ErrSix, addBookPagePO.returnTableOfErrors().contains("Price is required."));

    }
}
