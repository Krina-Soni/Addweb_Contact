package Com.Addweb.Pages;
import Com.Addweb.Actions.ActionClass;
import Com.Addweb.Actions.VerificationClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactUs {


    WebDriver driver;
    ExtentTest extentTest;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit-submit\"]")
    private WebElement SubmitBTN;
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit-name\"]")
    private WebElement Fullname;
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit-email\"]")
    private WebElement EmailAddress;
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit-phone\"]")
    private WebElement PhoneNumber;
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"edit-description\"]")
    private WebElement Description;
    @FindBy(how = How.ID,
            using = "edit-name")
    private WebElement USername;
    @FindBy(how = How.XPATH,
            using = "/html/body/div[2]/div/main/div/div/div[3]/article/div/div/div[22]/div/div/div[2]/div/span")
    private WebElement VALIDATION;
    @FindBy(how = How.XPATH,
            using = "//*[@id=\"block-aws-content\"]/article/div/div/div[1]/div/div/h1/span[1]")
    private WebElement Thankyou;


    public ContactUs(WebDriver driver, ExtentTest test) {

        this.driver = driver;
       this.extentTest = test;
        PageFactory.initElements(driver, this);

    }
//
//    public void ChecktheValidation() throws InterruptedException {
//        ActionClass actionClass = new ActionClass(driver, extentTest);
//        JavascriptExecutor jsetaskscore2 = (JavascriptExecutor) driver;
//        jsetaskscore2.executeScript("scrollBy(0, 1000)");
//        Thread.sleep(1000);
//        actionClass.clickOnObject(this.SubmitBTN);
//        String s = driver.switchTo().activeElement().getAttribute("data-webform-required-error");
//        System.out.println(s);
////        String s = driver.findElement(By.id("edit-name")).getAttribute("data-webform-required-error");
////        System.out.println(s);
//        Thread.sleep(3000);
//        driver.quit();

   // }

    public void EnterData(String Entername, String EnterEmail, String EnterPhone, String AddDescription) throws InterruptedException, IOException {
        ActionClass actionClass = new ActionClass(driver, extentTest);
        JavascriptExecutor jsetaskscore2 = (JavascriptExecutor) driver;
        jsetaskscore2.executeScript("scrollBy(0, 1000)");
        actionClass.clickOnObject(this.USername);
        actionClass.setValueinTextbox(this.USername, Entername);
        actionClass.setValueinTextbox(this.EmailAddress, EnterEmail);
        actionClass.clickOnObject(this.PhoneNumber);
        actionClass.setValueinTextbox(this.PhoneNumber, EnterPhone);
        actionClass.clickOnObject(this.Description);
        actionClass.setValueinTextbox(this.Description, AddDescription);
        actionClass.clickOnObject(this.SubmitBTN);
        String s = driver.findElement(By.id("edit-name")).getAttribute("data-webform-required-error");
        String s1 = driver.findElement(By.id("edit-email")).getAttribute("data-webform-required-error");
        String s2 = driver.findElement(By.id("edit-phone")).getAttribute("data-webform-required-error");
        String s3 = driver.findElement(By.id("edit-description")).getAttribute("data-webform-required-error");
        Boolean Bs = actionClass.CheckActiveField(s);
        Boolean Bs1 = actionClass.CheckActiveField(s1);
        Boolean Bs2 = actionClass.CheckActiveField(s2);
        Boolean Bs3 = actionClass.CheckActiveField(s3);
            if (Bs = true ||  (Bs1 = true) || (Bs2 = true) || (Bs3 = true) ){
                actionClass.CheckActiveField(s);
                actionClass.CheckActiveField(s1);
                actionClass.CheckActiveField(s2);
                actionClass.CheckActiveField(s3);
                actionClass.captureScreen("Contact Form with Invalid Field entries");
            }
            else {
                VerificationClass Matchthankyou = new VerificationClass(this.driver, extentTest);
                Matchthankyou.verifyTextPresent(this.Thankyou, "Thank you!");
                actionClass.captureScreen("Thanks for Submission");
            }
    }
    public void Checkcaptchavalidation(String Entername, String EnterEmail, String EnterPhone, String AddDescription) throws InterruptedException, IOException {
        ActionClass actionClass = new ActionClass(driver, extentTest);
        JavascriptExecutor jsetaskscore2 = (JavascriptExecutor) driver;
        jsetaskscore2.executeScript("scrollBy(0, 1000)");
        actionClass.clickOnObject(this.USername);
        actionClass.setValueinTextbox(this.USername, Entername);
        actionClass.clickOnObject(this.EmailAddress);
        actionClass.setValueinTextbox(this.EmailAddress, EnterEmail);
        actionClass.clickOnObject(this.PhoneNumber);
        actionClass.setValueinTextbox(this.PhoneNumber, EnterPhone);
        actionClass.clickOnObject(this.Description);
        actionClass.setValueinTextbox(this.Description, AddDescription);
        actionClass.clickOnObject(this.SubmitBTN);
        Thread.sleep(1000);
        JavascriptExecutor jsetaskscore3 = (JavascriptExecutor) driver;
        jsetaskscore2.executeScript("scrollBy(0, 1000)");
        Thread.sleep(1000);
        VerificationClass verifyClass = new VerificationClass(this.driver,extentTest);
        verifyClass.verifyTextPresent(this.VALIDATION, "The answer you entered for the CAPTCHA was not correct.");
        actionClass.captureScreen("Verification for Captcha");
    }

    public void Submittheform(String Entername, String EnterEmail, String EnterPhone, String AddDescription) throws InterruptedException, IOException {
        ActionClass actionClass = new ActionClass(driver,extentTest);
        JavascriptExecutor jsetaskscore2 = (JavascriptExecutor) driver;
        jsetaskscore2.executeScript("scrollBy(0, 1000)");
        actionClass.clickOnObject(this.USername);
        actionClass.setValueinTextbox(this.USername, Entername);
        actionClass.clickOnObject(this.EmailAddress);
        actionClass.setValueinTextbox(this.EmailAddress, EnterEmail);
        actionClass.clickOnObject(this.PhoneNumber);
        actionClass.setValueinTextbox(this.PhoneNumber, EnterPhone);
        actionClass.clickOnObject(this.Description);
        actionClass.setValueinTextbox(this.Description, AddDescription);
        actionClass.captureScreen("Check Information");
        actionClass.clickOnObject(this.SubmitBTN);
        VerificationClass Matchthankyou = new VerificationClass(this.driver,extentTest);
        Matchthankyou.verifyTextPresent(this.Thankyou, "Thank you!");
        actionClass.captureScreen("Thanks for Submission");
        driver.get("https://mail.google.com");
        GmailPageObjects gp = new GmailPageObjects(driver,extentTest);
        gp.enterEmail("krina.addweb@gmail.com");//Replace with your email id
        gp.enterPassword("addweb123");//Replace with your password
        Thread.sleep(10000);
        gp.clickEmail("Thanks for your enquiry at Addweb Solution");//Replace with email subject you want to click
        Thread.sleep(10000);
        actionClass.captureScreen("Thanks for Submission");
    }
    public void Validation()throws IndexOutOfBoundsException,InterruptedException{
        ActionClass actionClass=new ActionClass(driver,extentTest);
        String s = driver.switchTo().activeElement().getAttribute("data-webform-required-error");
        System.out.println(s);
    }
}