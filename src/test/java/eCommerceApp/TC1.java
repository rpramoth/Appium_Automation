package eCommerceApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import demo.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author Pramoth
 *
 */
public class TC1 extends Base{

	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = desiredCapabilities("Emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"))");

		
		driver.findElementByAndroidUIAutomator("text(\"Bangladesh\")").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
	}
	
}
