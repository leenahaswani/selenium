package SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy (how=How.ID, using = "user-name")
	WebElement username;
	
	@FindBy (how=How.ID, using = "password")
	WebElement password;
	
	@FindBy (how=How.ID, using = "login-button")
	WebElement loginButton;
	
	public LoginPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void enterPwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void submit()
	{
		loginButton.click();
	}

}
