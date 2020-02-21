package Com.Addweb.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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



    public GmailPageObjects(WebDriver driver)
    {
        this.driver=driver;
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

    public void clickEmail(String emailSubject)
    {
        waitForVisible(driver, profileLogo);

        for (int i = 0; i < emailThreads.size(); i++) {

            if (emailThreads.get(i).getText().contains(emailSubject)) {
                emailThreads.get(i).click();
                System.out.println("email clicked");
                break;
            }
        }
    }
    public void waitForVisible(WebDriver driver, WebElement element) {
        try {
            Thread.sleep(1000);
            System.out.println("Waiting for element visibility");
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

