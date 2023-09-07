package SauceDemo;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FinalTestPage {
	
	WebDriver driver = new ChromeDriver();
	LoginPage lp= new LoginPage(driver);
	GettingLoginDataFrmPptsFile g = new GettingLoginDataFrmPptsFile("C:\\Users\\lavei\\eclipse-workspace\\Selenium\\src\\SauceDemo\\config.properties");
	ChoosingtheProduct cp = new ChoosingtheProduct(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	Scanner S = new Scanner(System.in);
	checkoutInfo ch = new checkoutInfo(driver);
	
	@BeforeTest 
	public void getUrl()
	{
		driver.get(g.getUrl());
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1)
	public void getUname() throws InterruptedException
	{
		Thread.sleep(2000);
		lp.enterUsername(g.getUsername());
	}
	
	@Test (priority = 2)
	public void getPwd() throws InterruptedException
	{
		Thread.sleep(2000);
		lp.enterPwd(g.getPwd());
	}
	
	@Test (priority = 3)
	public void submit() throws InterruptedException
	{
		Thread.sleep(2000);
		lp.submit();
	}
	
	@Test (priority =4)
	public void checkUrlOfProds()
	{
		String pUrl="https://www.saucedemo.com/v1/inventory.html";
		Assert.assertTrue(pUrl.equals(driver.getCurrentUrl()));
	}
	
	@Test (dependsOnMethods = {"checkUrlOfProds"})
	public void printPrices()
	{
		cp.select();
		
	}
	
	@Test (dependsOnMethods = {"printPrices"})
	public void matchProduct()
	{
		WebElement price = driver.findElement(By.className("inventory_details_price"));
		Assert.assertTrue(ChoosingtheProduct.maxVal == Float.valueOf(price.getText().replace("$", "")) );
	}
	
	@Test (dependsOnMethods = {"matchProduct"})
	public void addToCart() throws InterruptedException
	{
		
		Thread.sleep(2000);
		WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='ADD TO CART']")));
		addToCart.click();
		Thread.sleep(2000);
		WebElement cart = driver.findElement(By.xpath("//*[@data-icon='shopping-cart']"));
		cart.click();
		Thread.sleep(2000);
		WebElement checkOut= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='CHECKOUT']")));
		checkOut.click();
	}
	
	@Test (dependsOnMethods = {"addToCart"})
	public void provideCheckoutData() throws InterruptedException
	{
		System.out.println("Please enter your first name");
		String fname = S.next();
		System.out.println("Please enter your last name");
		String lname = S.next();
		System.out.println("Please enter your zipcode");
		String zipcode= S.next();
		System.out.println("Go back to browser");
		
		ch.enterUserData(fname, lname, zipcode);
		
	}
	
	@Test (dependsOnMethods = {"provideCheckoutData"})
	public void rematchProduct() throws InterruptedException
	{
		WebElement price = driver.findElement(By.className("summary_subtotal_label"));
		Thread.sleep(2000);
		if(ChoosingtheProduct.maxVal == Float.valueOf(price.getText().replace("Item total: $", "")) )
		{
			driver.findElement(By.linkText("FINISH")).click();
		}
	}
	
	@Test (dependsOnMethods = {"rematchProduct"})
	public void confirmPlacement()
	{
		
		Assert.assertTrue(driver.getPageSource().contains("THANK YOU FOR YOUR ORDER"));
		
	}
	
	

}
