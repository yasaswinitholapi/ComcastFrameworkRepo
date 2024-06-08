package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for contact module
 * @author Yasaswini
 */
public class SearchContactTest extends BaseClass{
@Test
public void searchContactTest() {
	/*
	 * scenario:login()==>navigateContact==>cratecontact()==verify
	 * */
LoginPage lp=new LoginPage(driver);
lp.loginToapp("url", "username", "password");
}
}
