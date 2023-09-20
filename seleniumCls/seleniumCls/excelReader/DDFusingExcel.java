package excelReader;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.excelReader2;

public class DDFusingExcel {

	WebDriver driver;
	
	@BeforeClass
	void init()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
	}
	
	@Test(dataProvider = "Logindata")
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
	
	@DataProvider(name = "Logindata")
	public String[][] getlogindata() throws IOException
	{

		excelReader2 reader= new excelReader2(".\\src\\test\\resources\\Test.xlsx");
		
		
		
		int rwcount=reader.getRowCount("Sheet1");
		int colcount=reader.getCellCount("Sheet1", 1);
		
		String loginData[][]= new String[rwcount][colcount];
		
		for(int i=1; i<=rwcount; i++)
		{
			for (int j=0; j<colcount; j++)
			{
				loginData[i-1][j]=reader.getCellData("Sheet1", i, j);
			}
		}
		
		return loginData;
		
	}


}
