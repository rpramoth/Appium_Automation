package eCommerceApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import demo.Base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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
// Validate the long press in the checkout page

public class TC5 extends Base{

	public static void main(String[] args) throws MalformedURLException {


		AndroidDriver<AndroidElement> driver = desiredCapabilities("Android Device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
//		driver.findElementByAndroidUIAutomator("text(\"Argentina\")").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String[] productsNeeded = {"Jordan 6 Rings","PG 3"};
		double productSum=0;
		for(int l=0;l<productsNeeded.length;l++) {
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\""+productsNeeded[l]+"\"))");
			int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
			System.out.println("Count is "+count);
			for(int i =0;i<count;i++) {
				String productName = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
				if(productName.equals(productsNeeded[l])) {
					String price=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
					System.out.println(price);
					driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();		
					productSum+=Double.valueOf(price.substring(1));
				}

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
		



	}





}
