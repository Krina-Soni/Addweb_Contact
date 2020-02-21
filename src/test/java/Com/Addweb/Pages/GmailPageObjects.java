package Com.Addweb.Pages;

import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPageObjects {

    private WebDriver driver;
    @FindBy(how=How.XPATH, xpath="//input[@id='identifierId']")
    WebElement emailField;

    @FindBy(how=How.XPATH, xpath="//*[@id='password']/div[1]/div/div[1]/input")
    WebElement passwordField;

    @FindBy(how=How.XPATH, xpath="//span[@class='bog']")
    List<WebElement> emailThreads;

    @FindBy(how=How.XPATH, xpath="//span[@class='gb_bb gbii']")
    WebElement profileLogo;

    public static ExtentTest test;


    public GmailPageObjects(WebDriver driver,ExtentTest test)
    {
        this.driver=driver;
        this.test=test;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String emailID)
    {
        waitForVisible(driver, emailField);
        Actions actions=new Actions(driver);
        actions.moveToElement(emailField);
        actions.click();
        actions.sendKeys(emailID + Keys.ENTER);
        actions.build().perform();
        System.out.println("Email entered");
    }

    public void enterPassword(String password)
    {
        waitForVisible(driver, passwordField);
        Actions actions=new Actions(driver);
        actions.moveToElement(passwordField);
        actions.click();
        actions.sendKeys(password + Keys.ENTER);
        actions.build().perform();
        System.out.println("Password entered");
    }

    public void clickEmail(String emailSubject) throws InterruptedException {
//        waitForVisible(driver, profileLogo);

        for (int i = 0; i < emailThreads.size(); i++) {

            if (emailThreads.get(i).getText().contains(emailSubject)) {
                emailThreads.get(i).click();
                Thread.sleep(5000);
                System.out.println("Mail is Received");
                test.log(Status.INFO,"email is received");
                break;
            }
           else
            {
                Thread.sleep(5000);
                System.out.println("Mail is not received Received");
                test.log(Status.FAIL,"Email is not Received");
                break;
            }
        }
    }
    public void waitForVisible(WebDriver driver, WebElement element) {
        try {
            Thread.sleep(1000);
            System.out.println("Waiting for element visibility");
            WebDriverWait wait = new WebDriverWait(driver, 15);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

