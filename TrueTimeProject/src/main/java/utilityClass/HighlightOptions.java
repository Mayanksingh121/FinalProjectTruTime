package utilityClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class HighlightOptions {

//	public void highlight(WebElement element,WebDriver driver) {
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:2px solid red;');", element);
//	}
	public void flash(WebElement element, WebDriver driver) throws InterruptedException {
	    String originalBorderStyle = element.getCssValue("border");
	    
	    	setBorder("4px solid red", element, driver);
	    	Thread.sleep(500);
	        setBorder(originalBorderStyle, element, driver);
	}

	public void setBorder(String borderStyle, WebElement element, WebDriver driver) throws InterruptedException {
	    JavascriptExecutor js = ((JavascriptExecutor) driver);
	    js.executeScript("arguments[0].style.border = '" + borderStyle + "'", element);
	    Thread.sleep(20);
	}

}
