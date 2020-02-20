package Com.Addweb.Testcase;
import java.sql.SQLException;


import Com.Addweb.Constants.CommonVar;
import Com.Addweb.Testcase.Contact;
import Com.Addweb.Reports.ReportClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
public class BaseCase extends ReportClass {

    public static WebDriver driver;

    /*
 Below method will execute before each testcase.
     */
    @BeforeMethod
    public void initialize() throws SQLException
    {
        System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"chromedriver");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("headless");

        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe" );
        //driver = new ChromeDriver(options);
        //driver.get("http://toolsqa.com/automation-practice-form/");
        //driver.get("http://toolsqa.com/automation-practice-table/");
        //driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
        //System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"chromedriver");
        driver = new ChromeDriver();
        CommonVar common=new CommonVar();
        driver.get(common.url);
        driver.manage().window().maximize();

    }


    /*
 Below method will execute after each testcase.
     */
//    @AfterMethod
//    public void tearDown()
//    {
//        driver.quit();
//    }
}
