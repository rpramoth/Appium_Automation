package demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

/**
 * @author Pramoth
 *
 */
public class Swiping extends Base {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElementsByClassName("android.widget.RadialTimePickerView$RadialPickerTouchHelper").get(8).click();
		//long press on the element move to the desired element then release
		TouchAction touch = new TouchAction(driver);
		
		AndroidElement source = driver.findElement(By.xpath("//*[@content-desc='15']"));
		AndroidElement target = driver.findElement(By.xpath("//*[@content-desc='45']"));

		touch.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(1))).moveTo(element(target)).release().perform();
				
		
		
		
		
	}
	
}
