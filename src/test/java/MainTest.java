import org.openqa.selenium.Keys;
import annotation.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class MainTest {
    private static MainTest instance;
    public static WebDriver driver;
    private static HomePage page;


    private MainTest(WebDriver driver) {
        if (driver == null) {
            driver = new ChromeDriver();

        } else {
            this.driver = driver;
        }
    }

    public static void firstTest(WebDriver driver) {
        driver.get("https://pastebin.com");
        WebElement textArea = driver.findElement(By.id("postform-text"));
        textArea.sendKeys("Hello from WebDriver");

        page = new HomePage(driver);
        page.clickElement(driver, "//span[@id='select2-postform-expiration-container']");

        page.waitUntilPresenseOfElement(driver, "//span[@id='select2-postform-expiration-container']");
        page.clickElement(driver, "//li[text()='10 Minutes']");

        page.setText(driver, "//input[@id='postform-name']", "helloweb");

        page.clickElement(driver, "//button[@class='btn -big']");

    }

    @Test
    public static void secondTest(WebDriver driver) {
        page = new HomePage(driver);
        driver.get("https://pastebin.com");
        String title = "how to gain dominance among developers";
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        page.setText(driver, "//*[@id=\"postform-text\"]", code);


        page.clickElement(driver, "//span[@id='select2-postform-expiration-container']");
        page.waitUntilPresenseOfElement(driver, "//span[@id='select2-postform-expiration-container']");

        page.clickElement(driver, "//li[text()='10 Minutes']");


        page.setText(driver, "//input[@id='postform-name']", title);


        page.clickElement(driver, "//button[@class='btn -big']");

        page.waitUntilPresenseOfElement(driver, "//h1[text()='title']");
        String pasteName = driver.findElement(By.xpath("//h1[text()='title']")).getText();

        Assert.assertTrue(pasteName.equals(title));


        String savedCode = driver.findElement(By.xpath("//div[@class=\"de1\"]")).getText();
        Assert.assertTrue(savedCode.equals(code));

    }


}
