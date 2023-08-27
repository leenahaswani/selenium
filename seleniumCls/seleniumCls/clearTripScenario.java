package seleniumCls;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clearTripScenario {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cleartrip.com");

		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement whereFrom = driver.findElement(By.xpath("//input[@placeholder='Where from?']"));
		action.sendKeys(whereFrom, "Bangalore").perform();
		action.sendKeys(Keys.RETURN).perform();

		// Wait for the auto-suggest dropdown to appear (example: using explicit wait)

		WebElement autoSuggestDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[text() = 'Bangalore, IN - Kempegowda International Airport (BLR)']"))); // Replace with

		// Find and click on the desired city from the dropdown options
		WebElement desiredCityOption1 = autoSuggestDropdown1
				.findElement(By.xpath("//p[contains(text(), 'Bangalore')]")); // Replace with the actual locator
		desiredCityOption1.click();

		WebElement whereTo = driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
		action.sendKeys(whereTo, "Pune").perform();
		action.sendKeys(Keys.RETURN).perform();

		WebElement autoSuggestDropdown2 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() = 'Pune, IN - Lohegaon (PNQ)']")));

		WebElement desiredCityOption2 = autoSuggestDropdown2.findElement(By.xpath("//p[contains(text(), 'Pune')]")); // Replace
		desiredCityOption2.click();

		WebElement openCalendar = driver.findElement(By.xpath("//span[text()='Search flights']/parent::div/preceding-sibling::div//button"));
		openCalendar.click();
	
		List<WebElement> activeDates=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@aria-disabled='false']")));
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement actualCalendarView=openCalendar.findElement(By.xpath("//span[text()='Search flights']/parent::div/preceding-sibling::div//button"));
		js.executeScript("arguments[0].scrollIntoView(true);", actualCalendarView);

//		List<WebElement> columns = activeDates.findElements(By.xpath("//*[@aria-disabled='false']"));
		
		String day="27";
		for(WebElement cell:activeDates)
		{
			String celltext=cell.getText();
			System.out.println(celltext);
			if(celltext.contains(day))
			{
				cell.click();
//				actualCalendarView.findElement(By.xpath("//div[@aria-disabled='false' and @text()='"+day+"']")).click();
				break;
			}
		
			
		}
		
		Thread.sleep(2000);
		
		WebElement searchFlights = driver.findElement(By.xpath("//span[text()='Search flights']"));
		searchFlights.click();
		
	//WebDriver d=new FirefoxDriver();
		
		Thread.sleep(2000);
		
		WebElement bookButton= wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/main/div/div/div[2]/div[2]/div[8]/div/div[1]/div[1]/div/div[2]/div[4]/div[2]/button")));
		bookButton.click();
}
}


