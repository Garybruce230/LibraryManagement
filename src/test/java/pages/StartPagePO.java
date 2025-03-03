package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPagePO extends BasePagePO{

    WebDriver driver;
    @FindBy(xpath = "//button[@type='submit']")  // Update with actual locator
    private WebElement startNowButton;

    @FindBy(xpath = "//h1")
    private WebElement mainHeadingContent;

    @FindBy(xpath = "//h2[contains(text(),'Business Requirement')]")
    private WebElement businessReqeuestHeading;


    @FindBy(xpath = "//h2[contains(text(),'Task')]")
    private WebElement taskHeading;


    @FindBy(xpath = "//h2[contains(text(),'Important Guidelines')]")
    private WebElement importantGuidelinesHeading;


    @FindBy(xpath = "//h2[contains(text(),'Introduction')]")
    private WebElement InductionHeading;



    public StartPagePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 60);
    }
    public void clickStartNow() {

        click(startNowButton);
    }

    public String startButtonText()
    {
        return returnText(startNowButton);

    }

    public String returnH1Content(){
        return  returnText(mainHeadingContent);
    }

    public String returnTaskContent(){
        return returnText(taskHeading);
    }

    public String returnBusinessReqeuestHeading(){
        return returnText(businessReqeuestHeading);
    }

    public String returnImportantGuidelinesHeading(){
        return returnText(importantGuidelinesHeading);
    }

    public String retunrInductionHeading(){
        return returnText(InductionHeading);
    }

}
