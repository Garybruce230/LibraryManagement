package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePO extends BasePagePO {

    WebDriver driver;
    @FindBy(id = "username")  // Update with actual locator
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3")  // Update with actual locator
    private WebElement errorTitle;

    @FindBy(xpath = "//ul/li[1]")  // Update with actual locator
    private WebElement errorMessageOne;

    @FindBy(xpath = "//ul/li[2]")  // Update with actual locator
    private WebElement errorMessageTwo;



    @FindBy(xpath = "//*[contains(text(),'Welcome, Admin!')]")  // Update with actual locator
    private WebElement heardingText;

    public LoginPagePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public  void enterId(String username){
        usernameField.clear();
        enterText(usernameField, username);
    }
    public  void enterPassword(String password) {
        passwordField.clear();
        enterText(passwordField, password);

    }

        public void clickLoginButton(){
        click(loginButton);
    }

        public String returnErrorTitle(){
        return returnText(errorTitle);
        }

        public String returnErrorMessageOne(){return returnText(errorMessageOne);}

          public String returnErrorMessageTwo(){return returnText(errorMessageTwo);}
        public String returnHeadingText(){
        return returnText(heardingText);
        }
}
