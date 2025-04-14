package pageObgects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Класс для общих элементов сайта и общих действий
 */
public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By title = By.className("display-6");

    // Actions
    @Step("Getting current url")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Get page title")
    public WebElement getPageTitle() {
        return driver.findElement(title);
    }

    // Methods -> for ex open another Page Object
}
