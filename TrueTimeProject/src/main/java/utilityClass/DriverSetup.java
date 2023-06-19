package utilityClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverSetup {
	public static WebDriver driver=null;
	public static Properties props;
	
	public static WebDriver invokeBrowser() throws FileNotFoundException, IOException {
		props = new Properties();
		props.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Config\\application.properties")); // Loading the properties
		String browser = props.getProperty("browserName");

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				
				// create object of options class
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--disable-blink-features=AutomationControlled");
				co.addArguments("--disable-notifications");// Disabling any notifications
				driver = new ChromeDriver(co);
			}
			else if (browser.equalsIgnoreCase("edge")) {
				
				// create object of Options class
				EdgeOptions e = new EdgeOptions();
				e.addArguments("--disable-blink-features=AutomationControlled");
				e.addArguments("--disable-notifications");// Disabling any notifications
				driver = new EdgeDriver(e);
			}
			else {
				throw new IllegalArgumentException("Invalid browser name");
			}
		} catch (Exception e) {
			System.out.println("We couldn't find the requested browser : opening edge by default");

			EdgeOptions e1 = new EdgeOptions();
			driver = new EdgeDriver(e1);
		}
			// To maximize the browser.
			driver.manage().window().maximize();

		return driver;
	}
	

}
