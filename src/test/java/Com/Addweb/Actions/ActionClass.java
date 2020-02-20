package Com.Addweb.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionClass {
    public static WebDriver driver;
    public static ExtentTest test;

    public ActionClass(WebDriver driver,ExtentTest test)
    {
        this.driver=driver;
        this.test=test;
    }

    public void clickOnObject(WebElement element)
    {
        try {
            if(element.isDisplayed())
            {
                element.click();
               test.log(Status.INFO,"Sucessfully clicked on object : "+element.getAttribute("name"));
                System.out.println("Sucessfully clicked on object : "+element.getAttribute("name"));
            }
            else
            {
                System.out.println("Unable to find object : "+element.getAttribute("name"));
                test.log(Status.FAIL,"Unable to find object : "+element.getAttribute("name"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
           test.log(Status.FAIL,e.getMessage());
        }
    }
    public void setValueinTextbox( WebElement element, String value)
    {
        try {
            if(element.isDisplayed())
            {
                element.clear();
                element.sendKeys(value);
                System.out.println("Succesfully entered '"+value+"' in object :" + element.getAttribute("name"));
                test.log(Status.INFO,"Succesfully entered '"+value+"' in object :" + element.getAttribute("name"));
            }
            else
            {
                System.out.println("Unable to find object : "+element.getAttribute("name"));
                test.log(Status.FAIL,"Unable to find object : "+element.getAttribute("name"));

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }
    public Boolean CheckActiveField(String s)
    {

       String s1 = driver.switchTo().activeElement().getAttribute("data-webform-required-error");

        try {
            if(s1.equals(s))
            {
                test.log(Status.INFO,"Field has Invalid Data: "+s1);
                System.out.println("Field has Invalid Data: "+ s1);
            }
            else
            {
                System.out.println("Unable to find object : "+ s1);
                //           test.log(Status.FAIL,"Unable to find object : "+element.getAttribute("name"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    return null;
    }
    public static void captureScreen(String testcaseName) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        Date date = new Date();
        String datetextName = dateFormat.format(date);
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshot/" +testcaseName + "_"+datetextName + ".png" ;
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(screenshotPath);
        FileUtils.copyFile(SrcFile, DestFile);
        test.addScreenCaptureFromPath(screenshotPath);
    }
}
