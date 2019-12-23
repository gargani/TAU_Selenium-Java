package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    static String driverName = "safari";
    protected HomePage hompage;
    String url = "https://the-internet.herokuapp.com/";
    private WebDriver driver;

    @BeforeClass
    public void Setup() {

        String OS_Name = System.getProperty("os.name").toLowerCase();
        System.out.println(OS_Name);

        switch (driverName.toLowerCase()) {
            case "chrome":
                //As per my Machine/MacBook
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
                break;
            //Just Add Maven dependency, no need to download SafariDriver separately.

            case "safari":
                System.setProperty("webdriver.safari.driver", "true");
                driver = new SafariDriver();
                driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
                break;
        }


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
