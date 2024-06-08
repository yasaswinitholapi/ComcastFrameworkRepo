package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;
	public  ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	
	private WebElement createContactBtn;
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getCreateNewOrgBtn() {
		// TODO Auto-generated method stub
		return createContactBtn;
	}
	 

}
