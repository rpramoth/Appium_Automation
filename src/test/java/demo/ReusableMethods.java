package demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ReusableMethods {

	public static AndroidDriver<AndroidElement> desiredCapabilities(String deviceName) throws MalformedURLException {
		
		
		File file = new File(new File("src/test/java/resources"),"General-Store.apk");
		// we use desiredCapabilities to define the device name and the app name
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		ds.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,15);
		ds.setCapability(MobileCapabilityType.VERSION, "9.0");
		ds.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
		if(deviceName.equalsIgnoreCase("Emulator"))
			ds.setCapability(MobileCapabilityType.DEVICE_NAME, "PramothApp");
		else
			ds.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

		ds.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		ds.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),ds);

		return driver;
	}

	public static AndroidDriver<AndroidElement> browserDesiredCapabilities() throws MalformedURLException {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		ds.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		ds.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),ds);
		return driver;
	
	
	}


}
