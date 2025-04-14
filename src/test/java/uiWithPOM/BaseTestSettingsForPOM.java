package uiWithPOM;

import config.ITestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

class BaseTestSettingsForPOM {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseTestSettingsForPOM.class);
    ITestPropertiesConfig config = ConfigFactory.create(ITestPropertiesConfig.class, System.getProperties());

    WebDriver driver;
//    protected Actions actions;
//    protected JavascriptExecutor js;
//    protected WebDriverWait wait5sec;

    @BeforeEach
    void setup() {
        if (!config.isRemote()) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        actions = new Actions(driver);
//        js = (JavascriptExecutor) driver;
//        wait5sec = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
