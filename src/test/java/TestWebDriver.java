import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        SingletonClass.getDriver(driver);

        WebDriver driverSafari = new SafariDriver();
        SingletonClass.getDriver(driverSafari);

        WebDriver operaDriver = new OperaDriver();
        SingletonClass.getDriver(operaDriver);
    }
}
