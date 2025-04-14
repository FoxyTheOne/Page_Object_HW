package pageObgects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    private static final String NAVIGATION_URL = "navigation1.html";

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get page url")
    public String getUrl() {
        return NAVIGATION_URL;
    }
}
