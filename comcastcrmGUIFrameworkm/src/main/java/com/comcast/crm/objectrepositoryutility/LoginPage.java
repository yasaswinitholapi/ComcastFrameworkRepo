package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;
/**
 * @author Yasaswini
 * contains Login pageelements & busuiness libraries like login
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{//Rule-1 create a seperate java class
	
	WebDriver driver;
	public  LoginPage(WebDriver driver) {     //rule3object creaton
		//ths constructor wll tae care of loadng the object
		this.driver=driver;
		//store that browser sesson n drver object
		PageFactory.initElements(driver,this);
	}
	//Rule-2 object creaton by ths we can dentfy all the web elemnts @fndby
	@FindBy(name="user_name")
	private WebElement  usernameEdt;
	@FindBy(name="user_password")
	private WebElement  passwordEdt;
	@FindBy(id="submitButton")
	private WebElement  loginBtn;
	//ule-3 object nttalzaton t wll be done n testscrpts
	//rule-4 object encapsulaton
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * login to  application based on username,password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	//provde acton
	public void loginToapp(String url,String username,String password) {
		waitForPageToLoad(driver);
		//no need towrte mplct wat
	     driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
}
