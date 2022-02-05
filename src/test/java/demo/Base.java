package demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.HomePage;

public class Base extends ReusableMethods{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// In Appium, class will serve as tag name
		//class= android.widget.TextView
		HomePage hp = new HomePage(driver);
		hp.preferenceLink.click();
		
	//	driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Pramoth");
	//	driver.findElement(By.id("android:id/button1")).click();  -- will work		
		List<AndroidElement> list = driver.findElements(By.className("android.widget.Button"));
		for(AndroidElement e: list) {
			if(e.getText().equals("OK")) {
				e.click();
			}
		}
			
	}
	
}
