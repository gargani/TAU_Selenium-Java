package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
        String os_Name = System.getProperty("os.name").toLowerCase();
        String currentDirectory = System.getProperty("user.dir").toLowerCase();
        String java_Version = System.getProperty("java.version").toLowerCase();

        System.out.println(os_Name);
        System.out.println(currentDirectory);
        System.out.println(java_Version);

        if (os_Name.contains("mac") && driverName == "safari") {
            switch (driverName.toLowerCase()) {
                case "chrome":
                    //Code to handle SSL certifcates (if any)
                    DesiredCapabilities capChrome = DesiredCapabilities.chrome();
                    capChrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                    //As per my Machine/MacBook
                    System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
                    break;
                //Just Add Maven dependency, no need to download SafariDriver separately.
                case "safari":
                    //Code to handle SSL certifcates (if any)
                    DesiredCapabilities capSafari = DesiredCapabilities.safari();
                    capSafari.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                    System.setProperty("webdriver.safari.driver", "true");
                    driver = new SafariDriver();
                    driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);
                    break;

                case "firefox":
                    //Code to handle SSL certifcates (if any)
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setAcceptUntrustedCertificates(true);

                    System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
                    break;
            }
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
