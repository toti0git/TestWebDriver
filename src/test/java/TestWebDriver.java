import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//        GoogleCloudPage googlePage = new GoogleCloudPage(driver);
//        googlePage.hardCode();


      PastebinHomePage pastebin = new PastebinHomePage(driver);
      pastebin.bringItOn();


    }
}
