package eCommerceApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import demo.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//TC2 -- Shop the item by scrolling to the specific product and click on add to cart 
/**
 * @author Pramoth
 *
 */
public class TC2 extends Base{

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");


		driver.findElementByAndroidUIAutomator("text(\"Argentina\")").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))");

		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		System.out.println(count);
		for(int i =0;i<count;i++) {
			String productName = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			System.out.println(productName);
			if(productName.equals("Jordan 6 Rings")) {
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).resource");




	}


}
