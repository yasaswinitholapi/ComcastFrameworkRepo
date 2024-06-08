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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;

public class Genercegtestase3CreateOrganzaton extends BaseClass {
@Test
	public  void Genercegtestase3CreateOrganzaton()throws Throwable {
		// TODO Auto-generated method stub
		
		String orgName=eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber=eLib.getDataFromExcel("org", 7, 3).toString();
		//String type=row.getCell(4).toString();
		//when change te type nto inter i.e without 'using this if we using it takes as a string n  that partcular cell
		
		
		//step1:login to application
		//2navgate o  organzatons module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		//3 clc on create organzaton
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		//4enter all the detals and create organzaton
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrgPhoneNumber(orgName,phoneNumber);
		
		
		//logout from the application
		
			
		//Verify header org nfo expected result
			
		String	actPhoneNumber=driver.findElement(By.id("dtlview_Phone")).getText();
		 
		if(actPhoneNumber.equals(phoneNumber))
			System.out.println(phoneNumber + "nfo is created==PASS");
		else
			System.out.println(phoneNumber + "nfo is created==FAIL");
			
		//Verify the ndustres and type nfo
		/*
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
		*/
		
	}

}
