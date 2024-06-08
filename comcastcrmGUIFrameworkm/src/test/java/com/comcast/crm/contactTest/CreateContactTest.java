package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import javax.print.attribute.standard.Finishings;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
/**
 * @author Yasaswini
 *
 * */
public class CreateContactTest extends BaseClass {
	@Test(groups="smokeTest")
	public void CreateContactTest() throws Throwable {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers2/chromedriver.exe");

		/* read testscript data from 1excel*/
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// when change te type nto inter i.e without 'using this if we using it takes as
		// a string n that partcular cell
		/* navgate to contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		// clc on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewOrgBtn().click();
		// Enter all the dtals and create new contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(lastName);
		//
		String actHeader=cp.getHeaderMsg().getText();
		boolean status=actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert soft=new SoftAssert();
		Assert.assertEquals(actLastName,lastName );
	}
@Test(groups="regressionTest")
public void CreateContactWithSupportDateTest() throws Throwable {
	String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
	// when change te type nto inter i.e without 'using this if we using it takes as
	// a string n that partcular cell
	// step1:login to application	
	// step2: navgate to contacts module
	HomePage hp=new HomePage(driver);
	hp.getContactLink().click();
	// step3:clc on create contact button
	ContactsPage cp=new ContactsPage(driver);
	cp.getCreateNewOrgBtn().click();
	//step4:enter all thedetals &crete new contact
	String startDate = jLib.getSystemDateyyyyDDMM();
	String endDate = jLib.getRequiredDateYYYYDDMM(30);
	CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
	ccp.createContactWithSupportDate (lastName,startDate,endDate);
	
	String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
	
	if (actStartDate.equals(startDate)) {
		System.out.println(startDate + "is verified==PASS");
	} else {
		System.out.println(actStartDate + "is not verified==FAIL");
	}
	String actEndDate = driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();

	if (actEndDate.equals(endDate)) {
		System.out.println(endDate + "is verified==PASS");
	} else {
		System.out.println(endDate + "is not verified==FAIL");
	
}
	
}
@Test(groups="regressionTest")
public  void  CreateContactWthOrgTesteg4()throws Throwable {
	// TODO Auto-generated method stub

	//ntegraton test case
	//read common data from command line
	
	
	//read testscrpt from excel fle
	String orgName=eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
	String contactLastName=eLib.getDataFromExcel("contact", 7, 3);
	//when change te type nto inter i.e without 'using this if we using it takes as a string n  that partcular cell
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	
	OrganizationsPage cnp=new OrganizationsPage(driver);
	cnp.getCreateNewOrgBtn().click();
	
	CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
	cnop.createOrg(orgName);
	
	//step2:navigate to organization module
	
	String	actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
	System.out.println(actOrgName);
	 
	if(actOrgName.trim().equals(orgName))
		System.out.println(orgName + "nfo is created==PASS");
	else
		System.out.println(orgName + "nfo is created==FAIL");
	//navgate to conatct module	
hp.getContactLink().click();
//step:6 clc on create contact buttonn'
ContactsPage cp=new ContactsPage(driver);
cp.getCreateNewOrgBtn().click();
//step7:eneter all the detals and new contact
CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
ccp.createContactWithOrg(contactLastName, orgName);
	actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
System.out.println(actOrgName);
 
if(actOrgName.trim().equals(orgName))
	System.out.println(orgName + "nfo is created==PASS");
else
	System.out.println(orgName + "nfo is created==FAIL");


}
}
