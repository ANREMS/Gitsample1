package Utilities;

import Base.BaseUI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager extends BaseUI {

    public static ExtentReports extent;
    public static ExtentSparkReporter spark;

    /************** Getting report instance for Extent Report ****************/
    public static ExtentReports getReportInstance() {
        extent = new ExtentReports();
        String repName = "TestReport-"+BaseUI.timestamp+".html";
        spark = new ExtentSparkReporter(System.getProperty("user.dir")
                + "/TestOutput/"+repName); // spark is to save the report
        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "UST");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User Name", "Annadurai");
        spark.config().setDocumentTitle("Title of the Report Comes here ");
        // Name of the report
        spark.config().setReportName("Name of the Report Comes here ");
        // Dark Theme
        spark.config().setTheme(Theme.DARK);

        return extent;
    }



}
