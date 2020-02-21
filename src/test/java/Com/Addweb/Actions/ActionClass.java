package Com.Addweb.Actions;

import Com.Addweb.Pages.ContactUs;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

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

    public JsonNode sendSimpleMessage() throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/coffee.addwebsolution.com/messages")
                .basicAuth("api", "key-451293589637938ec918c46432a98a04")
                .field("from", "coffee@addwebsolution.com")
                .field("to", "krina.addweb@gmail.com")
                .field("subject", "hello")
                .field("text", "testing")
                .asJson();
        if (request.getBody()==null)
        {
            HttpResponse <JsonNode> request1 = Unirest.get("https://api.mailgun.net/v3/coffee.addwebsolution.com/bounces")
                    .basicAuth("api", "key-451293589637938ec918c46432a98a04")
                    .asJson();
            System.out.println(request1.getBody());
            test.log(Status.INFO,"Mail is Bounce, please check the bounce response" +request1.getBody());
            return request1.getBody();
        }
        else
        {
            test.log(Status.INFO,"Mail is received please check the email");
            System.out.println(request.getBody());
        }
        return request.getBody();
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
