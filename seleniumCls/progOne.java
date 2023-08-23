package seleniumCls;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class progOne {

	public static void main(String[] args) {
		WebDriver d=new EdgeDriver();
		d.get("https://www.cleartrip.com");

		 d.manage().window().maximize();

		 Actions action = new Actions(d);

		 WebDriverWait wait = new WebDriverWait(d, Duration.ofMinutes(1));
		 

		 WebElement whereFrom = d.findElement(By.xpath("//input[@placeholder='Where from?']"));

		 action.sendKeys(whereFrom, "Bangalore").perform();

		 action.sendKeys(Keys.RETURN).perform();		 

		 // Wait for the auto-suggest dropdown to appear (example: using explicit wait)
		 

		 WebElement autoSuggestDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(

		 By.xpath("//p[text() = 'Bangalore, IN - Kempegowda International Airport (BLR)']"))); // Replace with


		 // Find and click on the desired city from the dropdown options

		 WebElement desiredCityOption1 = autoSuggestDropdown1

		 .findElement(By.xpath("//p[contains(text(), 'Bangalore')]")); // Replace with the actual locator

		 desiredCityOption1.click();


		 

		 WebElement whereTo = d.findElement(By.xpath("//input[@placeholder='Where to?']"));

		 action.sendKeys(whereTo, "Pune").perform();

		 action.sendKeys(Keys.RETURN).perform();


		 

		 WebElement autoSuggestDropdown2 = wait.until(

		 ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() = 'Pune, IN - Lohegaon (PNQ)']")));


		 

		 WebElement desiredCityOption2 = autoSuggestDropdown2.findElement(By.xpath("//p[contains(text(), 'Pune')]")); // Replace

		 desiredCityOption2.click();


		 

		 WebElement openCalendar = d

		 .findElement(By.xpath("//span[text()='Search flights']/parent::div/preceding-sibling::div//button"));

		 openCalendar.click();
		 WebElement mydate = d.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[4]/div[5]/div[1]/div[1])"));
				 mydate.click();

	}

}
