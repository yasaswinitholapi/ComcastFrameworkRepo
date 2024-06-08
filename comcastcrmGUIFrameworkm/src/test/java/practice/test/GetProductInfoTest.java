package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
@Test(dataProvider = "getData")
public void getProductInfoTest(String brandName ,String productName) {
	System.setProperty("webdriver.chrome.driver", "./drivers2/chromedriver.exe");	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in");
	
	//search product

	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
	//capture product
	
	//String x="//span[text()='Apple iPhone 15 (128 GB) - Black']/../../../../div[3]/div[1]/div/div[1]/div[1]/div/a/span/span[2]/span[2]";
	String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div/a/span/span[2]/span[2]";
	String price= driver.findElement(By.xpath(x)).getText();
    System.out.println(price);
    driver.quit();
}
@DataProvider
public Object[][] getData() throws Throwable{
	ExcelUtility eLib=new ExcelUtility();
	int rowCount=eLib.getRowCount("product");
	
	Object[][] objArr=new Object[rowCount-1][2];
	for(int i=0; i<rowCount-1;i++) {
		
	objArr[i][0]=eLib.getDataFromExcel("product",i+1,1);
	objArr[i][1]=eLib.getDataFromExcel("product",i+1,1);
	}
	
	
	
	return objArr;
}

}
