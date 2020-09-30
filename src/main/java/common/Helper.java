package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Here will we implementing general waiting and browser action functionality
 */
public class Helper {

    private WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageLoaded() {
        new WebDriverWait(this.driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected void waitWithSpecificTime(long milliseconds) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(milliseconds);
    }

    protected void waitTillElementIsVisible(WebElement element) {
        new WebDriverWait(this.driver, 10).pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitTillElementIsInvisible(WebElement element) {
        new WebDriverWait(this.driver, 10).pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected WebElement findElementByCssSelector(String selector) {
        return this.driver.findElement(By.cssSelector(selector));
    }
}
