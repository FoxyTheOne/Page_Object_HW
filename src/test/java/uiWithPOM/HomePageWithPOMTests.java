package uiWithPOM;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObgects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("POM")
class HomePageWithPOMTests extends BaseTestSettingsForPOM {
    HomePage homePage;

    @BeforeEach
    void setup2() {
        homePage = new HomePage(driver);
    }

    @Test
    void openHomePageTest() {
//        homePage.open();

        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }
}

