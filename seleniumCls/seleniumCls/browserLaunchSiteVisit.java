package seleniumCls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class browserLaunchSiteVisit {

	public static void main(String[] args) {
		WebDriver d=new EdgeDriver();
		d.get("https://demoqa.com/");
	}

}
