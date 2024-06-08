package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;

public class CreateOrganzatonWthndutsrygenerceg2  extends BaseClass{
@Test
	public  void CreateOrganzatonWthndutsrygenerceg2() throws Throwable {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			
			
			String orgName=eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
			String industry=eLib.getDataFromExcel("org", 4, 3);
			String type=eLib.getDataFromExcel("org", 4, 4);
			//when change te type nto inter i.e without 'using this if we using it takes as a string n  that partcular cell
			
			HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();			
			//clc on create organzaton button
			OrganizationsPage cnp=new OrganizationsPage(driver);
			cnp.getCreateNewOrgBtn().click();
			//enter all the detals and create new organzaton		
			CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
			cnop.createOrg(orgName, industry,type);
			
			
			
			//Verify the ndustres and type nfo
		String actIndustries=driver.findElement(By.id("dtlview_Industry")).getText();
			if(actIndustries.equals(industry))
				System.out.println(industry + " info is verified==PASS");
			else
				System.out.println(industry + " info is not verified==FAIL");
			String actType=driver.findElement(By.id("dtlview_Type")).getText();
			if(actType.equals(type))
				System.out.println(type + "is verified==PASS");
			else
				System.out.println(type + "is not verified==FAIL");
			
	}

}
