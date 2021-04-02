import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement findElementByXpath(WebDriver driver,String xpath) {

        WebElement element = driver.findElement(By.xpath(xpath));
        return element;

    }

    public void clickElement(WebDriver driver, String xPath) {
        driver.findElement(By.xpath(xPath)).click();

    }

    public WebElement findElementById(String id) {
        WebElement element = driver.findElement(By.id(id));
        return element;

    }
    public void setText(WebDriver driver, String xPath, String text){
        driver.findElement(By.xpath(xPath)).sendKeys(text);


    }


    public void setTextAndChooseResult(WebDriver driver,String xPath,  String text){
        driver.findElement(By.xpath(xPath)).sendKeys(text, Keys.ENTER);

    }
    public void waitUntilPresenseOfElement(WebDriver driver, String xpath) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

    }


}
