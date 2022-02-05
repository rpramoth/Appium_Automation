package automateBrowser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import demo.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Browse extends Base{


	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = browserDesiredCapabilities();
		driver.navigate().to("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		driver.findElement(By.cssSelector("a[href*='products']")).click();
		driver.findElement(By.xpath("//h1[text()='Product List']")).isDisplayed();
		//		
		//		JavascriptExecutor js = (JavascriptExecutor)driver;
		//		js.executeScript("window.scrollBy(0,1000)", "");

		List<AndroidElement> list=	driver.findElements(By.xpath("//li[@class='list-group-item']/div/div/a"));

		for(AndroidElement e: list) {
			if(e.getText().equalsIgnoreCase("Devops")) {
				e.click();
			}
		}
		





	}


}
