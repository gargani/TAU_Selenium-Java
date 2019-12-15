package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By Username = By.id("username");
    private By Password = By.id("password");
    private By LoginButton = By.cssSelector("#login button");
    //Constructor to instatiate webdriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String StrUsername) {
        driver.findElement(Username).sendKeys(StrUsername);
    }

    public void setPassword(String StrPassword) {
        driver.findElement(Password).sendKeys(StrPassword);
    }

    public SecureAreaPage clickLogin() {
        driver.findElement(LoginButton).click();
        return new SecureAreaPage(driver);
    }

}
