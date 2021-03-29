import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestWebDriver {
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.google.com/");
       Thread.sleep(20000);
       driver.quit();

        WebDriver driverSafari = new SafariDriver();
        driverSafari.navigate().to("http://www.google.com/");
        Thread.sleep(30000);
        driverSafari.close();

        WebDriver operaDriver = new OperaDriver();
        operaDriver.navigate().to("http://www.vk.com");
        operaDriver.quit();
    }
}
