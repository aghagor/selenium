package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * In this class will be implemented driver creation functionality
 */
public class DriverProvider {
    private WebDriver driver;

    public WebDriver getDriver(String driver) {
        this.driver = setChromeDriver(driver);
        return this.driver;
    }

    private WebDriver setChromeDriver(String driver) {
        switch (driver.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                this.driver = new EdgeDriver();
                break;
        }

        return this.driver;
    }


}
