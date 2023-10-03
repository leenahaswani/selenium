package amazonCameraShopping;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] args) throws FileNotFoundException {
		
		WebDriver driver= new ChromeDriver();
		Scanner S = new Scanner(System.in);
		SearchItem si = new SearchItem(driver);
		ItemListExtraction l = new ItemListExtraction(driver);
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		if(driver.getTitle().equals("Amazon.in"))
		{
			WebElement cap = driver.findElement(By.id("captchacharacters"));
			System.out.println("Please enter value exactly as shown in the image");
			String capValue=S.next();
			cap.sendKeys(capValue);
			System.out.println("Please return back to the browser");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		else
		{
			System.out.println("No captcha required");
		}
		
		si.search();
		l.getItemList();

	}

}
