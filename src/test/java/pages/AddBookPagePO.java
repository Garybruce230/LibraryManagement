package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBookPagePO extends BasePagePO{
    WebDriver driver;

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(id = "author")
    private WebElement author;

    @FindBy(id = "genre")
    private WebElement genre;

    @FindBy(id = "isbn")
    private WebElement isbn;

    @FindBy(id = "publicationDate")
    private WebElement publicationDate;

    @FindBy(id = "price")
    private WebElement price;

    @FindBy(xpath = "//button[contains(text(),'Add Book')]")
    private WebElement addBookButton;

    @FindBy(xpath = "//ul")
    private WebElement tableforerros;

    @FindBy(xpath = "//h3")  // Update with actual locator
    private WebElement errorTitle;

    // Locate the LI elements within the UL
    //  private List<WebElement> liElements = tableforerros.findElements(By.xpath("//li"));



    public AddBookPagePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addBookDetails(String titleName, String authorName,String genreName ,String isbnNAme ,String DateOfPub, String Amount)
    {
        enterText(title, titleName);
        enterText(author, authorName);
        enterText(genre, genreName);
        enterText(isbn, isbnNAme);
        enterText(publicationDate, DateOfPub);
        enterText(price, Amount);
    }

    public void setAddBookButton(){
        click(addBookButton);
    }

    public String returnTableOfErrors(){
        return returnText(tableforerros);
    }


    public String returnErrorHeader(){
        return returnText(errorTitle);
    }
}
