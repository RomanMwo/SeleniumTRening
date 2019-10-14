package framework;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {


    protected BaseDriver driver;
@BeforeMethod
    public void setUp() {

        driver = new FirefoxDriverImplementation();
        //driver = new ChromeDriverImplementation();
    }
    @AfterMethod
    public void tearDown() {
        driver.closeDriver();
    }
}
