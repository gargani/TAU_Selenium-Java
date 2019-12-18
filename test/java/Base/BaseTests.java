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

        //As per my Machine/MacBook
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        hompage = new HomePage(driver);

        //driver.manage().window().setSize(new Dimension(375, 812));
        //System.out.println(driver.getTitle());
    }

    @AfterClass
    public void Teardown() {
        driver.quit();
    }


}
