package SauceDemo;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class checkoutInfo {
	
	public WebDriver driver;
	
	
	@FindBy(how=How.XPATH, using ="//*[@placeholder='First Name']")
	WebElement Fname;
	
	@FindBy(how=How.XPATH, using ="//*[@placeholder='Last Name']")
	WebElement Lname;
	
	@FindBy(how=How.XPATH, using ="//*[@placeholder='Zip/Postal Code']")
	WebElement zipcode;
	
	@FindBy(how=How.XPATH, using ="//*[@value='CONTINUE']")
	WebElement cont;
	
	
	public checkoutInfo(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserData(String f, String l, String z) throws InterruptedException
	{
		Fname.sendKeys(f);
		Thread.sleep(1000);
		Lname.sendKeys(l);
		Thread.sleep(1000);
		zipcode.sendKeys(z);
		Thread.sleep(3000);
		cont.click();
	}

}
