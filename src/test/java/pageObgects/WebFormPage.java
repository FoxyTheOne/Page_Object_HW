package pageObgects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageObgects.HomePage.BASE_URL;

public class WebFormPage extends BasePage {
    private static final String WEB_FORM_URL = "web-form.html";

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    WebElement submitButton = driver.findElement(By.xpath("//button[@type = 'submit']"));

    @Step("Get page url")
    public String getUrl() {
        return WEB_FORM_URL;
    }

    @Step("Submit form")
    public void submitForm() {
        submitButton.click();
    }

    @Step("Check that the page is Web form")
    public void checkIsWebPage() {
        assertAll(
                () -> assertEquals(BASE_URL + getUrl(), getCurrentUrl()),
                () -> assertEquals("Web form", getPageTitle().getText())
        );
    }
}
