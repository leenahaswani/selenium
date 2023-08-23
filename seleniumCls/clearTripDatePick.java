package seleniumCls;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class clearTripDatePick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cleartrip.com");

		driver.manage().window().maximize();
		
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		jse.executeScript("scroll(0, 250)");
//		
//		Thread.sleep(5000);
		
		WebElement openCalendar = driver
				.findElement(By.xpath("//span[text()='Search flights']/parent::div/preceding-sibling::div//button"));
		openCalendar.click();
		
		
		List<WebElement> columns = openCalendar.findElements(By.xpath("//*[@aria-disabled='false']"));
		String day="2";
		for(WebElement cell:columns)
		{
			String celltext=cell.getText();
			System.out.println(celltext);
			if (celltext.contains(day)) {
		                cell.click();
		                break;
		            }
			
		}
	}

}
