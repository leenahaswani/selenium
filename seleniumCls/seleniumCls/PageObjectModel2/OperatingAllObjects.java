//This file is to operate elements and chk data in both files

package PageObjectModel2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OperatingAllObjects {
	
	static WebDriver driver = new ChromeDriver();
	static ReadConfigFile rc = new ReadConfigFile("C:\\Users\\lavei\\eclipse-workspace\\Selenium\\src\\PageObjectModel2\\config.properties");
	static Login l= new Login(driver);
	
	@BeforeTest
	public static void launchURL()
	{
		driver.get(rc.getApplicationUrl());
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1)
	public static void getTitle()
	{
		Assert.assertTrue(driver.getTitle().equals(rc.getTitle()));
	}
	
	@Test (priority = 2)
	public static void enterUsername()
	{
		//l.enterUserName("leena@gmail.com");
		Assert.assertTrue(l.enterUserName("leena@gmail.com").equals(rc.getUsername()));
	}
	
	@Test (priority = 3)
	public static void enterPwd() throws InterruptedException
	{
		//l.enterPassword("kjyht");
		Thread.sleep(2000);
		Assert.assertTrue(l.enterPassword("kjyht").equals(rc.getPassword()));
	}
	
	@Test (priority = 4)
	public static void getForgottenPwdUrl() throws InterruptedException
	{
		Thread.sleep(2000);
		l.clickForgottenPassword();
		Assert.assertTrue(driver.getCurrentUrl().equals(rc.getForgottenPwdLink()));
	}

}
