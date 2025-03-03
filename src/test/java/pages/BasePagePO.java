package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePagePO {

    WebDriver driver;
    protected WebDriverWait wait;



    public BasePagePO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
    }
    protected WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void click(WebElement element) {
        waitForElement(element).click();
    }
    protected void enterText(WebElement element, String text) {
        //element.clear();
        waitForElement(element).sendKeys(text);
    }

    public String returnText(WebElement element) {
        return element.getText().trim();
    }


}
