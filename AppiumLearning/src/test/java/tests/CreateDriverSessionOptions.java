package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

public class CreateDriverSessionOptions {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "Apps" + File.separator + "ApiDemos-debug.apk";

		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
		options.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		options.setCapability(MobileCapabilityType.APP, appUrl);

		URL url = new URL("http://127.0.0.1:4723/");

		AppiumDriver driver = new AndroidDriver(url, options);

	}

}
