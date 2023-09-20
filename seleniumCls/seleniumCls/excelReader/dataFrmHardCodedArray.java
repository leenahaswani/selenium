package excelReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataFrmHardCodedArray {
	
	WebDriver driver;
	
	@BeforeClass
	void init()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
	}
	
	@Test(dataProvider = "Login data")
	public void passData(String uname, String pwd, String res) throws InterruptedException
	{
		
		
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.clear();
		email.sendKeys(uname);
		
		Thread.sleep(1000);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.clear();
		password.sendKeys(pwd);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title= driver.getTitle();
		
		if(res.equals("valid"))
		{
			if(exp_title.equals(act_title))
			{
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(res.equals("invalid"))
		{
			if(exp_title.equals(act_title))
			{
				
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		Thread.sleep(2000);
		
	}
	
	@DataProvider(name = "Login data")
	public String[][] getData()
	{
		String[][] loginData= {
				{"admin@yourstore.com", "admin", "valid"}, 
				{"admin@yourstore.com", "adm", "invalid"},
				{"adm@yourstore.com", "admin", "invalid"},
				{"adm@yourstore.com", "adm", "invalid"}
		};
		return loginData;
	}
	
	@AfterClass
	void closedriver()
	{
		driver.close();
	}

}
