package uiWithPOM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageObgects.HomePage;
import pageObgects.NavigationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObgects.HomePage.BASE_URL;

class NavigationWithPOMTests extends BaseTestSettingsForPOM {
    HomePage homePage;

    @BeforeEach
    void setup2() {
        homePage = new HomePage(driver);
    }

    @Test
    void openNavigationTest() {
//        homePage.open();
        // Реализуем переход между страницами:
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        WebElement title = navigationPage.getPageTitle();
        String webFormUrl = navigationPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Navigation example", title.getText());
    }
}
