package ui;

import config.ITestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

class BaseTest {
    protected static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    ITestPropertiesConfig config = ConfigFactory.create(ITestPropertiesConfig.class, System.getProperties());

    WebDriver driver;
    private Actions actions;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
