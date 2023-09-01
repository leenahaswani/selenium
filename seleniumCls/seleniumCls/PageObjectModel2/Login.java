//This file is to get elements from fb login page(only identification of elements)

package PageObjectModel2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement username;

	@FindBy(how = How.ID, using = "pass")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//a[text()='Forgotten password?']")
	WebElement forgottenPassword;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String enterUserName(String userDetails) {
		username.sendKeys(userDetails);
		return userDetails;
	}

	public String enterPassword(String pass) {
		password.sendKeys(pass);
		return pass;
	}

	public void clickForgottenPassword() {
		forgottenPassword.click();
	}
}
