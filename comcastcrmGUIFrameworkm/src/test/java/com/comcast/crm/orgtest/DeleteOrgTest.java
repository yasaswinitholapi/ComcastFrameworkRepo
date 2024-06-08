package com.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;

public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers2/chromedriver.exe");
		/*create object*/
		FileUtility fLib=new FileUtility();			
		ExcelUtility eLib=new  ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		//read common data from json file
		String BROWSER= fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String  USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
		String orgName=eLib.getDataFromExcel("org", 10, 2)+jLib.getRandomNumber();

		//when change te type nto inter i.e without 'using this if we using it takes as a string n  that partcular cell			
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("msedge")) {
			driver=new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		//step1:login to application
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30) );
		//driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL,"admin", "admin");
		//step2:navgate to organzaton module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		//clc on create new organzaton button
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		//step4:enter all the detals and create new organzaton
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		//
		// op.navigateToCampaignsPage();
		//veerfy   header message expected result
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		
		String actOrgName=oip.getHeaderMsg().getText();
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName+"name is verified==PASS");
		}
		else
			System.out.println(orgName+"name is not  verified==FAIL");
		//go bac to organzatons page
		
		hp.getOrgLink().click();	
		//search for organzatonn
		cnp.getSearchEdt().sendKeys(orgName);
		wlib.select(cnp.getSearchDD(), "Organization Name");
		cnp.getSearchBtn().click();
		
		//N dynamc webtable  select and delete org
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		//logout
		//hp.logout();
		//driver.quit();
	}

}
