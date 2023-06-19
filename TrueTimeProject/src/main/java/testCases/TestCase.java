package testCases;

import testModules.TrueTime;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilityClass.DriverSetup;

public class TestCase {
	
	
	public static WebDriver driver;
	TrueTime tt;
	
	
	@BeforeSuite
	public void openDriver() throws Exception{
		driver = DriverSetup.invokeBrowser();
	}
	
	@Test(priority=1)
	public void testOne() throws FileNotFoundException, IOException {
		tt=new TrueTime(driver);
		tt.openHomePage();
	}
	
	@Test(priority=2)
	public void testTwo() throws InterruptedException, IOException {
		tt=new TrueTime(driver);
		tt.userVerification();
		tt.showUserProfileData();
	}
	
	@Test(priority=3)
	public void testThree() {
		tt=new TrueTime(driver);
		tt.clickOneCognizant();
		tt.handlingWindows();
	}
	
	@Test(priority=4)
	public void testFour() throws InterruptedException {
		tt=new TrueTime(driver);
		tt.clickingTrueTime();
		tt.monthAndYear();
	}
	
	@AfterSuite
	public void testFive() {
		driver.quit();
	}

	
}
