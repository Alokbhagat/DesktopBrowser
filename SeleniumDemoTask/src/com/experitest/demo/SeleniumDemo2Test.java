package com.experitest.demo;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSElement;



public class SeleniumDemo2Test extends BaseTest {
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		
		try{
			dc.setCapability("platformName", "FireFox");
			dc.setCapability("testName", "Selenium Demo2 Test ");
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			dc.setCapability("newCommandTimeout", 120);
			driver = new RemoteWebDriver(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
		
			//this is test demo comment
		}catch(Exception ex){
	System.out.println(ex.getMessage());
	
           }		
}
		
		 

	
	@Test
	public void LaunchApplicationTest(){	
		
		int i = 0;		
		String companyName;
        driver.get("http://experitest.com/customers/");		
         //getting all logo web element in side the list 
		List<IOSElement> customers = driver.findElements(By.xpath("//*[@id='div']/img"));      
		//reading the web element info from list 
		for (WebElement webElement : customers) {
			i++;
			// Since there are lot of customers so restricted to print only 10 customers
			 if(i > 10){				
				break;
			}
			 // spliting up the string img src to short names
		     companyName = webElement.getAttribute("src");		     
		     String[] words=companyName.split("/");		     
			System.out.println("Customer Name:  " + words[6]);
			}	
				  
	 }
	
	
	@Test
	public void Test2(){	
		
		int i = 0;		
		String companyName;
        driver.get("http://experitest.com/customers/");		
         //getting all logo web element in side the list 
		List<IOSElement> customers = driver.findElements(By.xpath("//*[@id='div']/img"));      
		//reading the web element info from list 
		for (WebElement webElement : customers) {
			i++;
			// Since there are lot of customers so restricted to print only 10 customers
			 if(i > 10){				
				break;
			}
			 
			 
			 // spliting up the string img src to short names
		     companyName = webElement.getAttribute("src");		     
		     String[] words=companyName.split("/");		     
			System.out.println("Customer Name:  " + words[6]);
			}	
				  
	 }
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
