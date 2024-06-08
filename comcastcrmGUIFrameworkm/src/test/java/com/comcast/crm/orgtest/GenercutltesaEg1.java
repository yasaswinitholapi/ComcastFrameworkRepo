package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listnerutility.ListnerImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.listnerutility.ListnerImpClass.class)
public class GenercutltesaEg1 extends BaseClass {
	
	@Test(groups = "smokeTest")
	public void GenercutltesaEg12() throws Throwable {
		// TODO Auto-generated method stubths screateorgtest

		/* create object */
//ListnerImpClass.test.log(Status.INFO, "read data from excel");
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		// step2:navgate to organzaton module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// step3:clc on new organzaton button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		// step4:enter all the detals and create new organzaton
		ListnerImpClass.test.log(Status.INFO, " create org ");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName + "===> create a new org");

		//
		// op.navigateToCampaignsPage();
		// veerfy header message expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));

	}

	@Test(groups = "regressionTest")
	public void Genercegtestase3CreateOrganzaton() throws Throwable {
		// TODO Auto-generated method stub
		// create org wth phone number
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3).toString();
		// String type=row.getCell(4).toString();
		// when change te type nto inter i.e without 'using this if we using it takes as
		// a string n that partcular cell
		// step1:login to application
		// 2navgate o organzatons module
		UtilityClassObject.getTest().log(Status.INFO, "create a new  org");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// 3 clc on create organzaton
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		// 4enter all the detals and create organzaton
		UtilityClassObject.getTest().log(Status.INFO, "create a new org with phone number");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgPhoneNumber(orgName, phoneNumber);
		// logout from the application
		// Verify header org nfo expected result
		UtilityClassObject.getTest().log(Status.INFO, "verfy the phonenumber");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		Assert.assertEquals(true, actPhoneNumber.contains(phoneNumber));
		UtilityClassObject.getTest().log(Status.PASS, actPhoneNumber + "==>VERiFY the phone number wth organization");
		/*
		 * if(actPhoneNumber.equals(phoneNumber)) System.out.println(phoneNumber +
		 * "nfo is created==PASS"); else System.out.println(phoneNumber +
		 * "nfo is created==FAIL");
		 */
	}

	@Test(groups = "regressionTest")
	public void CreateOrganzatonWthndutsrygenerceg2() throws Throwable {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);
		// when change te type nto inter i.e without 'using this if we using it takes as
		// a string n that partcular cell
		UtilityClassObject.getTest().log(Status.INFO, "create a new org");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// clc on create organzaton button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		// enter all the detals and create new organzaton
		UtilityClassObject.getTest().log(Status.INFO, "create organzaton wth ndustry tyepe and name");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry, type);
		// Verify the ndustres and type nfo
		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		Assert.assertEquals(true, actIndustries.contains(industry));
		UtilityClassObject.getTest().log(Status.PASS, "verfed the ndustry wth organzaton");
		/*
		 * if(actIndustries.equals(industry)) System.out.println(industry +
		 * " info is verified==PASS"); else System.out.println(industry +
		 * " info is not verified==FAIL"); String
		 * actType=driver.findElement(By.id("dtlview_Type")).getText();
		 * if(actType.equals(type)) System.out.println(type + "is verified==PASS"); else
		 * System.out.println(type + "is not verified==FAIL"); }
		 */
	}
}
