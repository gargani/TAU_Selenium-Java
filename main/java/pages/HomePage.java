package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    //Constructor to instatiate webdriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickformAuthLink() {
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickOnHoverLink() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    private void clickLink(String LinkText) {
        driver.findElement(By.linkText(LinkText)).click();
    }
}
