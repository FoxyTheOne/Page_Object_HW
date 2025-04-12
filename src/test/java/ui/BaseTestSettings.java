package ui;

import config.ITestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

class BaseTestSettings {
    protected static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseTestSettings.class);
    ITestPropertiesConfig config = ConfigFactory.create(ITestPropertiesConfig.class, System.getProperties());

    WebDriver driver;
    protected Actions actions;
    protected JavascriptExecutor js;
    protected WebDriverWait wait5sec;

    @BeforeEach
    void setup() {
        if(!config.isRemote()){
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        wait5sec = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
