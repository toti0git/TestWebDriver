import annotation.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GoogleCloudPage {
    private WebDriver driver;
    private final String cloudURL = "https://cloud.google.com/";

    @FindBy(xpath = "//form[@class='devsite-search-form']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@name=\"q\"]")
    private WebElement searchArea;

    @FindBy(xpath = "//div[@class='gs-title']/a/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement searchResult;

    @FindBy(xpath = "//input[@id='input_65']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//div[@id=\"select_container_91\"]/md-select-menu/md-content/md-option")
    private List<WebElement> seriesList;

    @FindBy(xpath = "//md-select[@id=\"select_90\"]")
    private WebElement seria;

    @FindBy(xpath = "//md-select[@id=\"select_401\"]/md-select-value/span[1]")
    private WebElement gpuTypes;

    @FindBy(xpath = "//div[@class=\"md-select-menu-container md-active md-clickable\"]/md-select-menu/md-content/md-option")
    private List<WebElement> listOfGpuTypes;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox/div[1]")
    private WebElement gpuCheckbox;

    @FindBy(xpath = "//md-select-value[@id=\"select_value_label_397\"]/span[1]")
    private WebElement numberOfGpu;

    @FindBy(xpath = "//div[@class=\"md-select-menu-container md-active md-clickable\"]/md-select-menu/md-content/md-option")
    private List<WebElement> numbersOfGpus;

    @FindBy(xpath = "//md-select[@id=\"select_360\"]/md-select-value/span[1]")
    private WebElement localSSD;

    @FindBy(xpath = "//div[@class=\"md-select-menu-container md-active md-clickable\"]/md-select-menu/md-content/md-option")
    private List<WebElement> checkedLocalSSD;

    @FindBy(xpath = "//md-select[@id=\"select_94\"]/md-select-value/span[1]")
    private WebElement location;

    @FindBy(xpath = "//div[@class=\"md-select-menu-container md-active md-clickable\"]/md-select-menu/md-content/md-option")
    private List<WebElement> listOfLocations;

    @FindBy(xpath = "//md-select[@id=\"select_101\"]/md-select-value/span[1]")
    private WebElement usage;

    @FindBy(xpath = "//div[@class=\"md-select-menu-container md-active md-clickable\"]/md-select-menu/md-content/md-option")
    private List<WebElement> listOfUsage;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[15]/button")
    private WebElement estimateButton;

    @FindBy(xpath = "//md-list-item[@class=\"md-1-line md-no-proxy ng-scope\"]/div")
    private List<WebElement> estimateResults;

    @FindBy(xpath = "//md-list-item[@class=\"md-1-line md-no-proxy\"]/div")
    private List<WebElement> estimateResultPart;

    @FindBy(xpath = "//input[@id=\"mail_address\"]")
    private WebElement email;

    @FindBy(xpath = "//button[@id=\"email_quote\"]")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//input[@id=\"input_482\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"dialogContent_488\"]/form/md-dialog-actions/button[2]")
    private WebElement sendEmailGeneral;

    public GoogleCloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hurtMePlenty() throws InterruptedException {
        driver.get(cloudURL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String result = "Google Cloud Platform Pricing Calculator";
        waitUntilPresenseOfElement("//form[@class='devsite-search-form']");
        searchButton.click();
        searchArea.sendKeys(result, Keys.ENTER);
        waitUntilPresenseOfElement("//div[@class='gs-title']/a/b[text()='Google Cloud Platform Pricing Calculator']");
        searchResult.click();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");
        waitUntilPresenseOfElement("//md-select[@id=\"select_90\"]");
        seria.click();
        Thread.sleep(5000);
        seriesList.get(0).click();
        waitUntilPresenseOfElement("//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox/div[1]");
        gpuCheckbox.click();

        waitUntilPresenseOfElement("//md-select-value[@id=\"select_value_label_397\"]/span[1]");
        numberOfGpu.click();
        Thread.sleep(5000);
        numbersOfGpus.get(1).click();

        gpuTypes.click();
        Thread.sleep(5000);
        listOfGpuTypes.get(3).click();

        localSSD.click();
        waitUntilPresenseOfElement("//div[@class=\"md-select-menu-container md-active md-clickable\"]/md-select-menu/md-content/md-option[2]");
        checkedLocalSSD.get(2).click();

        location.click();
        waitUntilPresenseOfElement("//div[@class=\"md-select-menu-container md-active md-clickable\"]/md-select-menu/md-content/md-option[1]");
        listOfLocations.get(9).click();

        usage.click();
        Thread.sleep(3000);
        listOfLocations.get(1).click();

        estimateButton.click();
        Thread.sleep(3000);
        testEstimate();

    }

    public void waitUntilPresenseOfElement(String xpath) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

    }

    @Test
    public void testEstimate() {
        Assert.assertTrue(estimateResults.get(0).getText().contains("regular"));
        Assert.assertTrue(estimateResults.get(1).getText().contains("2x375 GiB"));
        Assert.assertTrue(estimateResults.get(2).getText().contains("1 Year"));
        Assert.assertTrue(estimateResultPart.get(0).getText().contains("2,920"));
        Assert.assertTrue(estimateResultPart.get(1).getText().contains("n1-standard-1"));
        Assert.assertTrue(estimateResultPart.get(2).getText().contains("Frankfurt"));
    }

    public void hardCode() throws InterruptedException{
        hurtMePlenty();

        ((JavascriptExecutor)driver).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com/");
        Thread.sleep(7000);
        String mail=email.getAttribute("value");
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        sendEmailButton.click();
        Thread.sleep(5000);
        emailInput.sendKeys(mail);
        sendEmailGeneral.click();


    }
}
