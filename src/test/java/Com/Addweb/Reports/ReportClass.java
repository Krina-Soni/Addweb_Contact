package Com.Addweb.Reports;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportClass {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void initReport() throws SQLException
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/Opera_Report.html");
        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "AddWeb Timesheet");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("User Name", "Krina");

        htmlReporter.config().setDocumentTitle("Addweb Timesheet");
        htmlReporter.config().setReportName("AddWeb Timesheet Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @AfterSuite
    public void tearDown() throws IOException {
        extent.flush();

    }
}
