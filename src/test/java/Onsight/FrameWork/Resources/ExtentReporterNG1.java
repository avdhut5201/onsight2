package Onsight.FrameWork.Resources;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports getReportObject() throws IOException
	{
		String path =System.getProperty("user.dir")+"//reports//index.html";
		File reporterFile=new File(path);
		
		if (reporterFile.exists()) {
			ExtentSparkReporter reporter = new ExtentSparkReporter(reporterFile);
			reporter.config().setReportName("Web Automation Results");
			reporter.config().setDocumentTitle("Test Results");
			
			ExtentReports extent =new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Avdhut Joshi");
			return extent;
			
		} else {
			reporterFile.createNewFile();
		}
		
		return null;
		
		
	}
}
