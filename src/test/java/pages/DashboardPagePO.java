package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPagePO extends BasePagePO{
    WebDriver driver;
    @FindBy(xpath = "//*[contains(text(),'Book List')]")  // Update with actual locator
    private WebElement bookListText;

    @FindBy(xpath = "//button[contains(text(),'Add Book')]")  // Update with actual locator
    private WebElement addBookButton;
    @FindBy(id = "delete-book-1")
    private WebElement deleteBookButton;

    @FindBy(id="edit-book-1")
    private WebElement editBookOne;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> bookList;

    @FindBy(xpath = "//h3")
    private WebElement TotalbookTitles;

    @FindBy(xpath = "//button[contains(text(),'Log Out')]")
    private WebElement logoutButton;
    public DashboardPagePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addBook() {
        click(addBookButton);
    }
    public void deleteBook() {
        click(deleteBookButton);
    }

    public void editBook() {
        click(editBookOne);
    }
    public int getBookCount() {
        return bookList.size();
    }
    public void logout() {
        click(logoutButton);
    }

    public String returnBookPageTitle() {
        return  returnText(bookListText);
    }

    public  String returnTotalBooks(){
        return  returnText(TotalbookTitles);
    }
}
