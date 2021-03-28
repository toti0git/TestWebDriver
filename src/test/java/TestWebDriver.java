import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebDriver {
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "/Users/nurzhanaimurzinov/Desktop/webdrivers/chromedriver");
       WebDriver driver = new ChromeDriver();
       driver.get("https://mvnrepository.com/");
       Thread.sleep(20000);
       driver.quit();
    }
}
