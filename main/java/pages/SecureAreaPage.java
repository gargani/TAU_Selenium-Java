package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;
    private By StatusAlert = By.id("flash");

    //Constructor to instantiate Webdriver
    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String VerifyStatus() {
        return driver.findElement(StatusAlert).getText();
    }

}
