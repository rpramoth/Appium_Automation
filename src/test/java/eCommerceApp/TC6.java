package eCommerceApp;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import demo.Base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import junit.framework.Assert;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

/**
 * @author Pramoth
 *
 */
// Perform action in WEBVIEW // contextHandles

public class TC6 extends Base{

	public static void main(String[] args) throws MalformedURLException {


		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String productsNeeded = "Jordan 6 Rings";
		double productSum=0;
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\""+productsNeeded+"\"))");
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		System.out.println("Count is "+count);
		for(int i =0;i<count;i++) {
			String productName = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			if(productName.equals(productsNeeded)) {
				String price=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
				System.out.println(price);
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();		
				productSum+=Double.valueOf(price.substring(1));
			}


		}
		System.out.println("Prices in the product page = "+productSum);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String pricesInCart= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double priceInCart = Double.valueOf(pricesInCart.substring(1));
		System.out.println("Prices in the cart page = "+priceInCart);

		Assert.assertEquals(productSum, priceInCart);

		AndroidElement checkBox = driver.findElementByClassName("android.widget.CheckBox");
		AndroidElement tnc = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

		TouchAction ta = new TouchAction(driver);
		ta.tap(tapOptions().withElement(element(checkBox))).perform();		
		ta.longPress(LongPressOptions.longPressOptions().withElement(element(tnc)).withDuration(ofSeconds(2))).release().perform();

		System.out.println("Terms and Condition is displayed "+driver.findElementByAndroidUIAutomator("text(\"Terms Of Conditions\")").isDisplayed());
		driver.findElementById("android:id/button1").click();

		driver.findElement(By.xpath("//android.widget.Button[@text='Visit to the website to complete purchase']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> context=driver.getContextHandles();
		for(String s: context) {

			System.out.println(s);

		}

		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Pramoth"+Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		
	}





}
