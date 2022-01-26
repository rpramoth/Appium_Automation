package demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class AndroidUIAutomator extends ReusableMethods {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		//("attribute("value")")
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

		//To verify the property values we use the below one

		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(false)").size());






	}

}
