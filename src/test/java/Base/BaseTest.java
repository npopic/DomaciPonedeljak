package Base;

import Pages.AddRemoveElementsPage;
import Pages.FormAuthenticationPage;
import Pages.LoggedInPage;
import Pages.WelcomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;
    public WelcomePage welcomePage;
    public AddRemoveElementsPage addRemoveElementsPage;
    public LoggedInPage loggedInPage;

    public FormAuthenticationPage formAuthenticationPage;

    @BeforeClass

    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        welcomePage = new WelcomePage(driver);
        formAuthenticationPage = new FormAuthenticationPage(driver);
        loggedInPage = new LoggedInPage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);

    }

    @AfterClass
    public void tearDown() {
       driver.manage().deleteAllCookies();
       driver.quit();
    }
}
