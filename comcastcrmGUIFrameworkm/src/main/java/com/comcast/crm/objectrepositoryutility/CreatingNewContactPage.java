package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewContactPage {
	
	WebDriverUtility wLib=new WebDriverUtility();
		WebDriver driver;
		public  CreatingNewContactPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);		
		}
		@FindBy(linkText="Contacts")
		private WebElement contactsLink;
		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement createContactBtn;
		@FindBy(name="lastname")
		private WebElement lastNameEdt;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		@FindBy(name="support_start_date")
		private WebElement startDateEdt;
		@FindBy(name="support_end_date")
		private WebElement endDateEdt;
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
		private WebElement contactNewOrgBtn;
		@FindBy(name="search_text")
		private WebElement plusSearchOrg;
		@FindBy(xpath="//a[text()='+orgName+']")
		private WebElement DynamicOrgName;
		@FindBy(name="search")
		private WebElement searchOrgBtn;
		
	   public void createContact(String lastName) {
		// TODO Auto-generated method stub
		contactsLink.click();
		createContactBtn.click();
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	public void createContactWithSupportDate(String lastName, String startDate, String endDate) {
		// TODO Auto-generated method stub
		contactsLink.click();
		createContactBtn.click();
		lastNameEdt.sendKeys(lastName);
		startDateEdt.clear();
		startDateEdt.sendKeys(startDate);
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);
		saveBtn.click();
		
	}
	public void createContactWithOrg(String contactLastName, String orgName) {
		// TODO Auto-generated method stub
		contactsLink.click();
		createContactBtn.click();
		lastNameEdt.sendKeys(contactLastName);
		contactNewOrgBtn.click();
		wLib.switchToTabonURL(driver,"module=Accounts");
		plusSearchOrg.sendKeys(orgName);
		searchOrgBtn.click();	
		driver.findElement(By.linkText(orgName)).click();
		wLib.switchToTabonURL(driver,"Contacts&action");			
		saveBtn.click();
	}

		
	}

