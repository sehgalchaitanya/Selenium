package test.Utilities;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
    private static ExtentSparkReporter sparkReporter;
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp
        String reportName = "Test-Report-" + timeStamp + ".html";
        String reportDir = System.getProperty("user.dir") + "/reports/";

        // Create reports directory if it doesn't exist
        File reportsDir = new File(reportDir);
        if (!reportsDir.exists()) {
            reportsDir.mkdirs();
        }

        sparkReporter = new ExtentSparkReporter(reportDir + reportName);
        sparkReporter.config().setDocumentTitle("Web Automation Test Report");
        sparkReporter.config().setReportName("Rest Assured API Tests");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
    }

    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed");
        test.get().log(Status.FAIL, result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped");
        test.get().log(Status.SKIP, result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}