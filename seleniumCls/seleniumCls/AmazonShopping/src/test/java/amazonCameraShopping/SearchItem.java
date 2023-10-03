package amazonCameraShopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchItem {
	
	WebDriver driver;
	
	public SearchItem(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void search()
	{
		WebElement prodName = driver.findElement(By.id("twotabsearchtextbox"));
		prodName.sendKeys("camera");
		
		WebElement dropDownBox = driver.findElement(By.id("searchDropdownBox"));
		dropDownBox.click();
		
		WebElement allCategories = driver.findElement(By.xpath("//option[text()='All Categories']"));
		allCategories.click();
		
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
		
		
	}

}
