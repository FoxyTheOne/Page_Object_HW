package uiWithPOM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pageObgects.HomePage;
import pageObgects.WebFormPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObgects.HomePage.BASE_URL;

class WebFormWithPOMTests extends BaseTestSettingsForPOM {
    HomePage homePage;

    @BeforeEach
    void setup2() {
        homePage = new HomePage(driver);
    }

    @Test
    void openWebFormTest() {
//        homePage.open();
        // Реализуем переход между страницами:
        WebFormPage webFormPage = homePage.openWebFormPage();
        String currentUrl = webFormPage.getCurrentUrl();
        WebElement title = webFormPage.getPageTitle();
        String webFormUrl = webFormPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());
    }

    @Test
    void openWebFormTestWithCheckMethod() {
//        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.checkIsWebPage();
    }

    @Test
    void submitFormTest() throws InterruptedException {
//        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.submitForm();
        Thread.sleep(2000);
    }
}
