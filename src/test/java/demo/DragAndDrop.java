package demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author Pramoth
 *
 */
public class DragAndDrop extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();

		TouchAction action = new TouchAction(driver);
		AndroidElement source = driver.findElements(By.className("android.view.View")).get(0);
		AndroidElement dest = driver.findElements(By.className("android.view.View")).get(1);
	//	action.longPress(longPressOptions().withElement(element(source))).moveTo(element(dest)).release().perform();
		action.longPress((element(source))).moveTo(element(dest)).release().perform();

		// both the ways we can write. the first one should be used if some additional methods like withDuration from long press is to be used
		
	}


}
