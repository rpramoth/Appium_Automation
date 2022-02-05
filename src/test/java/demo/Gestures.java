package demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.TouchAction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class Gestures extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		// Touch Action is there to perform this. This is similar to Action class of Selenium
		TouchAction action = new TouchAction(driver);

		// Tap Action
		AndroidElement expandableList = driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		action.tap(tapOptions().withElement(element(expandableList))).perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();

		// Long Press
		AndroidElement peopleName = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		action.longPress(longPressOptions().withElement(element(peopleName)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		
		 
	}
	
	
}
