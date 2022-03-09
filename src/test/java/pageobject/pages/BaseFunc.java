package pageobject.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunc {
    private WebDriver browser;
    private WebDriverWait wait;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public BaseFunc() {
        LOGGER.info("Starting Web Browser");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        wait = new WebDriverWait(browser, Duration.ofSeconds(10));
    }

    public void openUrl(String url) {
        LOGGER.info("Open page by: " + url);
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        browser.get(url);
    }

    public void click(By locator) {
        LOGGER.info("Clicking on element");
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }

    public List<WebElement> findElements(WebElement parent, By child) {
        return parent.findElements(child);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void select(By locator, String value) {
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    public void selectByVisibleText(By locator, String text) {
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(text);
    }

    public void type(By locator, String text) {
        WebElement inputField = findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void type(By locator, int text) {
        type(locator, String.valueOf(text));
    }

    public void waitUntilElementsCountAtLeast(By locator, int count) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, count));
    }
}
