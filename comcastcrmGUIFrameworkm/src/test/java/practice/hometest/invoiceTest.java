package practice.hometest;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import junit.framework.Assert;
//@Listeners(com.comcast.crm.listnerutility.ListnerImpClass.class)
public class invoiceTest extends BaseClass{
	
@Test
public void createInvoiceTest() {
	System.out.println("execute createInvoice");
	String actTitle= driver.getTitle();
	Assert.assertEquals(actTitle, "Login");
	//System.out.println(var);
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}

	/*
@Test(retryAnalyzer = com.comcast.crm.listnerutility.RetryListnerImp.class)
public void activatesim() {
	System.out.println("execute createInvoice");
	Assert.assertEquals("", "Login");
	//System.out.println(var);
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}

 */
@Test
public void createInvoiceWthContactTest() {
	System.out.println("excute createInvoiceWthContactTest");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}

}
