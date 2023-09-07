package SauceDemo;

//import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChoosingtheProduct {
	
	WebDriver driver;
	List<Float> finalPriceList = new ArrayList<Float>();
	float price;
	static float maxVal;
	//WebDriverWait wait= new WebDriverWait(driver, 1);
	
	
	public ChoosingtheProduct(WebDriver d)
	{
		driver = d;
		
	}
	
	public void select()
	{
		List<WebElement> priceList = driver.findElements(By.className("inventory_item_price"));
		for(WebElement c : priceList)
		{
			price=Float.valueOf(c.getText().replace("$", ""));
			//System.out.println(price);
			finalPriceList.add(price);
			
		}
		
		System.out.println(finalPriceList);
		maxVal=Collections.max(finalPriceList);
		
		WebElement maxValue=driver.findElement(By.xpath("//*[text()='"+maxVal+"']/../preceding-sibling::div[@class='inventory_item_label']/a"));
		maxValue.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='ADD TO CART']")));
//		addToCart.click();
	}

}
