
import annotation.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PastebinHomePage {
    WebDriver driver;

    private static final String pastebinURL = "https://pastebin.com";

    String title = "how to gain dominance among developers";
    String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    @FindBy(id = "postform-text")
    private WebElement textArea;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement expirationSelection;

    @FindBy(xpath = "//span[@id=\"select2-postform-format-container\"]")
    private WebElement syntaxHighlight;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement exp10Min;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement submit;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteTitle;

    @FindBy(xpath = "//div[@class=\"info-top\"]/h1")
    private static WebElement savedTitle;

    @FindBy(xpath = "//textarea/text()")
    private WebElement savedCode;

    @FindBy(xpath = "//span[@class='kw2']")
    private static WebElement rgbText;

    @FindBy(xpath = "//li[text()=\"Bash\"]")
    private WebElement bash;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public PastebinHomePage openPage() {
        driver.get(pastebinURL);
        new WebDriverWait(driver, 10);
        return this;
    }

    public void iCanWinTest() {
        driver.get(pastebinURL);
        waitUntilPresenseOfElement("//span[@id='select2-postform-expiration-container']");
        textArea.sendKeys("Hello from WebDriver");
        syntaxHighlight.click();
        waitUntilPresenseOfElement("//li[@id=\"select2-postform-format-result-xljc-8\"]");
        bash.click();
        expirationSelection.click();
        waitUntilPresenseOfElement("//span[@id='select2-postform-expiration-container']");
        exp10Min.click();
        pasteTitle.sendKeys("helloweb");
        submit.click();
    }

    @Test
    public void bringItOn() {
        driver.get(pastebinURL);
        new WebDriverWait(driver, 10);
        textArea.sendKeys(code);
        syntaxHighlight.click();
        waitUntilPresenseOfElement("//li[text()=\"Bash\"]");
        bash.click();
        expirationSelection.click();
        waitUntilPresenseOfElement("//span[@id='select2-postform-expiration-container']");
        exp10Min.click();
        pasteTitle.sendKeys(title);
        submit.click();
        testBringItOn();

    }

    public void waitUntilPresenseOfElement(String xpath) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

    }

    @Test
    public void testBringItOn() {
        Assert.assertTrue(savedTitle.getText().equals(title));
       // Assert.assertTrue(savedCode.equals(code));
        Assert.assertEquals(rgbText.getCssValue("color"), "rgba(185, 202, 74, 1)");
    }


}
