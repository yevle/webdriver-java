package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import underArmor.web.loadablePages.HomePage;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.get("https://www.underarmour.com");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
