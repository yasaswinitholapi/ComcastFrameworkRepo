package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTesteg2 {
	@Test
	public void homepageTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start");
		//Reporter.log(null);
	//	SoftAssert assertObj=new SoftAssert();
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		//Assert.assertEquals("HOME", "HOME");
		Reporter.log("step-3",true);
	//	assertObj.assertEquals("Title", "Title-1");
		Reporter.log("step-4",true);
		//assertObj.assertAll();
		//t 
		Reporter.log(mtd.getName()+"Test End");

	}
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start");
	//	SoftAssert assertObj=new SoftAssert();
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		//assertObj.assertTrue(true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		//assertObj.assertAll();
		Reporter.log(mtd.getName()+"Test End");

	}
}
