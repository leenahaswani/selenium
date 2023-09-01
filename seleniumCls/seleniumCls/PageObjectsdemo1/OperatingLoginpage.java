package PageObjectsdemo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OperatingLoginpage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		Login lg=new Login(driver);
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		lg.enterUserName("leena@gmail.com");
		
		Thread.sleep(2000);
		
		lg.enterPassword("pass");
		
		Thread.sleep(2000);
		
		lg.clickForgottenPassword();
		

	}

}
