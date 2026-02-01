package uitlities;



import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtendReportManager  implements ITestListener {
	

	public ExtentSparkReporter sparkReporter ;
	public ExtentReports  extent ;
	public ExtentTest test;
	String repName;
	 
	public void onStart(ITestContext context) {
		String timeStamp= new SimpleDateFormat("yyyy.MM..dd.HH.mm.ss").format(new Date());
		repName= "Test-Report"+timeStamp+".html";
		
		
		sparkReporter =new ExtentSparkReporter(".\\reports\\"+repName);
		sparkReporter.config().setDocumentTitle("Open-Cart Automation Testing...");
		sparkReporter.config().setReportName("Open-Cart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application ", "Open-Cart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
		extent.setSystemInfo("Enviroment", "QA");
		String os=  context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating-System", os);
		String browser= context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		List<String> includedGroup= context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroup.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroup.toString());
		}
	
	}
	public void onTestSuccess(ITestResult  result) {
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,"Test case Passed is: "+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL," Test case Failed Is :"+result.getName());
		try {
			String impPath= new BaseClass().captureScreenShot(result.getName());
			test.addScreenCaptureFromPath(impPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case skipped Is :"+result.getName());
	}
	public void onFinish(ITestContext context) {
		extent.flush();
		String pathOfExtendReport= System.getProperty("user.dir")+"\\reports\\"+repName;
		File extendReport= new File(pathOfExtendReport);
		try {
			Desktop.getDesktop().browse(extendReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
