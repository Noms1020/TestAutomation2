package ExtentsReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    static ExtentReports extentReports;
    static ExtentTest extentTest;

    public void onStart(ITestContext result){
        extentReports = ExtentsReportMananger.extentReports;
    }
     @Override
    public void onTestStart(ITestResult result){
        extentTest=extentReports.createTest(result.getMethod().getMethodName());
     }
     @Override
    public void onTestFailure(ITestResult result){
         extentTest.fail("test case"+result.getMethod().getMethodName()+"has failed");
     }@Override
    public void onTestSuccess(ITestResult result){
         extentTest.pass("Test case"+ result.getMethod().getMethodName()+"test has passed");
     }

     @Override
     public void onTestSkipped(ITestResult result){
         extentTest.skip("Test case"+result.getMethod().getMethodName()+"test skipped");
     }
     @Override
    public void onFinish(ITestContext result){
         extentReports.flush();

     }

}
