package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    private static ExtentReports extent;
    public static ExtentReports getInstance(){
        if(extent==null)
        {
            String reportPath=ConfigReader.get("reports.path");
            ExtentSparkReporter spark=new ExtentSparkReporter(reportPath);
            extent=new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

}
