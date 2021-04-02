import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonClass {
    private static SingletonClass instance;
    public WebDriver driver;

    private SingletonClass(WebDriver driver) {
        if (driver == null) {
            driver = new ChromeDriver();

        } else {
            this.driver = driver;
        }
    }

    public static SingletonClass getDriver(WebDriver driver) throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(20000);
        driver.quit();


        return instance;
    }
}
