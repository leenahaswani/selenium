package amazonCameraShopping;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.tools.javac.util.List;

public class ItemListExtraction {
	
	WebDriver driver;
	
	public ItemListExtraction(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void getItemList() throws FileNotFoundException
	{
		java.util.List<WebElement> itemList = driver.findElements(By.cssSelector("h2.a-size-mini"));
		java.util.List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='a-price']"));
		
		FileOutputStream file = new FileOutputStream(".\\src\\test\\resources\\output.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		
		System.out.println("The top 5 items are as below: ");
		
		for(int i=0; i<5; i++)
		{
			WebElement item = itemList.get(i);
			String name = item.getText();
			WebElement price = priceList.get(i);
			String pr = price.getText();
			System.out.println(name);
			System.out.println(pr);
		}
		ps.close();

	}

}
