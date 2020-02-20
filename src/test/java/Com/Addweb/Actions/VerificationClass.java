package Com.Addweb.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationClass {
    private static WebDriver driver;
    private static ExtentTest test;

    public VerificationClass(WebDriver driver, ExtentTest test){

        VerificationClass.driver = driver;
        VerificationClass.test = test;
    }

    public void verifyTextPresent(WebElement element, String expectedText) {
        try {
            if (element.isDisplayed()) {
                String text = element.getText();
                if (text.equals(expectedText)) {
                    test.log(Status.PASS, "Expected value '" + expectedText + "' matches with actual value '" + text + "' for the object : " + element.getAttribute("name"));
                    System.out.println("Expected value '" + expectedText + "' matches with actual value '" + text + "' for the object : " + element.getAttribute("name"));
                } else {
                   test.log(Status.FAIL, "Expected value '" + expectedText + "' did not matche with actual value '" + text + "' for the objectverifyLoggedInUser : " + element.getAttribute("name"));
                    System.out.println("Expected value '" + expectedText + "' did not matche with actual value '" + text + "' for the object : " + element.getAttribute("name"));
                }
            } else {
              test.log(Status.FAIL, "Unable to find object : " + element.getAttribute("name"));
            }
        } catch (Exception var4) {
            test.log(Status.ERROR, "Error in performing action");
            System.out.println(var4.getStackTrace());
        }

    }

}
