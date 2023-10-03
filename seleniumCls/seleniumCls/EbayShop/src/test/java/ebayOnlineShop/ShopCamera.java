package ebayOnlineShop;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopCamera {

	public static void main(String[] args) throws FileNotFoundException {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		
		WebElement searchBox = driver.findElement(By.id("gh-ac"));
		searchBox.sendKeys("camera");
		
		driver.findElement(By.id("gh-cat")).click();
		
		WebElement allCategoriesOption = driver.findElement(By.xpath("//option[text()='All Categories']"));
		allCategoriesOption.click();
		
		WebElement submit = driver.findElement(By.xpath("//input[@value='Search']"));
		submit.click();		
		
		List<WebElement> nameList =  driver.findElements(By.className("s-item__title"));
		List<WebElement> priceList = driver.findElements(By.className("s-item__price"));
		
		FileOutputStream file = new FileOutputStream(".\\src\\test\\resources\\output.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		
		for(int i = 0; i<5; i++)
		{
			String name = nameList.get(i).getText();
			String price = priceList.get(i).getText();
			
			System.out.println(name);
			System.out.println(price);
		}
				
		

	}

}
