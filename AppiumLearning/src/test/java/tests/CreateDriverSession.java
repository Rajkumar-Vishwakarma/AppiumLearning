package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CreateDriverSession {

	public static AppiumDriver initializeAppiumDriver() throws MalformedURLException {

		DesiredCapabilities dCaps = new DesiredCapabilities();
		dCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
		dCaps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		dCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "Apps" + File.separator + "ApiDemos-debug.apk";

		dCaps.setCapability("avd", "Nexus_5X_API_32");
		dCaps.setCapability("avdLaunchTimeout", 180000);
		
		//dCaps.setCapability("appPackage", "com.google.android.apps.maps");
		//dCaps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		dCaps.setCapability("newCommandTimeout", 300);
		dCaps.setCapability(MobileCapabilityType.APP, appUrl);

		URL url = new URL("http://127.0.0.1:4723/");

		AppiumDriver driver = new AndroidDriver(url, dCaps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;

	}

	public static void main(String args[]) throws MalformedURLException {

		AppiumDriver driver = CreateDriverSession.initializeAppiumDriver();
		System.out.println(driver.getSessionId());
		driver.quit();

	}

}
