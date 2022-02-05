package eCommerceApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import demo.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

/**
 * @author Pramoth
 *
 */
//Appname - General-Store.apk  // TC1 is enter user details and click the login button
public class TC1 extends Base{
	
	
	public static void postiveScenario() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");

		
		driver.findElementByAndroidUIAutomator("text(\"Argentina\")").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
	}

	public static void negativeScenario() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"))");

		
		driver.findElementByAndroidUIAutomator("text(\"Bangladesh\")").click();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		//  we cannot identify object for Toast.. Toast message will be developed like android.widget.Toast and name attribute will have the toast error message
		String actual = driver.findElementByXPath("//android.widget.Toast").getAttribute("name");
		System.out.println(actual);
		
		Assert.assertEquals("Please enter your name", actual);
		
	}
	
	
	
	public static void main(String[] args) throws MalformedURLException {
		negativeScenario();
	
	}
	
}
