package ExtentsReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentsReportMananger {
    static String reportDirector = System.getProperty("user.dir")+"tarhet/reports/TestAutomation.html";
    static ExtentReports extentReports;
    static ExtentSparkReporter extentSparkReporter;

    public static ExtentReports extentReports(){
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(new File(reportDirector));
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Test Automation Report");
        extentSparkReporter.config().setReportName("TestAutomation");

        extentReports.setSystemInfo("os",System.getProperty("os.name"));
        extentReports.setSystemInfo("execution machine",System.getProperty("user.name"));
        return extentReports;

    }

}
