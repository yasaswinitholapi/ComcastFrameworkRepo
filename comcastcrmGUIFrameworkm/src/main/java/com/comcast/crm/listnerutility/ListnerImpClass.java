package com.comcast.crm.listnerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListnerImpClass implements ITestListener , ISuiteListener{

	//public ExtentSparkReporter spark;
	//public static ExtentReports report;
	public  ExtentReports report;
	public static ExtentTest test;
	//public static ExtentTest test;f we ep ths as statc  t does not partcpate n parralelexecuton
	
	public void onStart(ISuite suite) {
	
	System.out.println("Report configuration");
	String time=new Date().toString().replace(" ", "_").replace(":", "_");
	 ExtentSparkReporter  spark=new ExtentSparkReporter("./Advancereport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test sute results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		//addd env nformaton &create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====  ===>"+result.getMethod().getMethodName()+">====START====");
		 test=report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"==>STARTED====");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====  ===>"+result.getMethod().getMethodName()+"===>END<=====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==>COMPLETED====");
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName= result.getMethod().getMethodName();
		//EventFiringWebDriver  edriver=new EventFiringWebDriver(BaseClass.sdriver);
		//step2:use getscreenshot method to get fletype of screenshot
		TakesScreenshot eDriver=(TakesScreenshot)BaseClass.sdriver;
		String filepath= eDriver.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==>FAILed<====");

		//step:store scrrenshot on local drver
	/*	try {
			FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+"+"+time+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	      
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	      
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	      
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	      
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	      
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
