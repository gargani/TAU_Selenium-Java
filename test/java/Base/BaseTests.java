package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {

    protected HomePage hompage;
    String url = "https://the-internet.herokuapp.com/";
    private WebDriver driver;

    @BeforeClass
    public void Setup() {
        //This project is created using Test Automation University Course by Angie Jones
        //https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter3.html

        //As per my MacBook
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        hompage = new HomePage(driver);

        //driver.manage().window().setSize(new Dimension(375, 812));
        //System.out.println(driver.getTitle());


    /*
    List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement ShiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        ShiftingContentLink.click();

        WebElement Example1 = driver.findElement(By.linkText("Example 1: Menu Element"));
        Example1.click();

        List<WebElement> Tabs = driver.findElements(By.tagName("li"));
        System.out.println(Tabs.size());
        String attribute = Tabs.get(2).getAttribute("name");
        System.out.println(attribute);

     */
    }

    @AfterClass
    public void Teardown() {
        driver.quit();
    }


}
