package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;

public class BaseClass {
	//create object 
	public DatabaseUtility dbLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public  ExcelUtility eLib=new  ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups={"smokeTest", "regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("connect to db,report confg");
		dbLib.getDbconnection();			
		}			
	//@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest", "regressionTest"})
	public void configBC() throws Throwable {
		//configBC(String browser)for cross browser execu
		System.out.println("launch the browser");
		System.setProperty("webdriver.chrome.driver", "./drivers2/chromedriver.exe");
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("msedge")) {
			driver=new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		sdriver=driver;
		//once browser launchng s done
		UtilityClassObject.setDriver(driver);
		
	}
	@BeforeMethod(groups={"smokeTest", "regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("login  to application ");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}
	@AfterMethod(groups={"smokeTest", "regressionTest"})
	public void configAM() {
		System.out.println("logout  to application");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	@AfterClass(groups={"smokeTest", "regressionTest"})
	public void configAC() {
		System.out.println("Close the browser");
		driver.quit();
	}
	@AfterSuite(groups={"smokeTest", "regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("close db, Report backup");
		dbLib.closeDbconnection();	
	}
}
