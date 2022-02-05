package eCommerceApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import demo.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

/**
 * @author Pramoth
 *
 */
// Validate the content in the cart is same as we added
// TC4 is also included -- validate the product sum is matching with the total

public class TC3 extends Base{

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
		String[] productsNeeded = {"Jordan 6 Rings","PG 3"};
		double productSum=0;
		for(int l=0;l<productsNeeded.length;l++) {
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\""+productsNeeded[l]+"\"))");
			int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
			System.out.println("Count is "+count);
			for(int i =0;i<count;i++) {
				String productName = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
				System.out.println(productName);
				System.out.println(productsNeeded[l]); 
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









	}





}
