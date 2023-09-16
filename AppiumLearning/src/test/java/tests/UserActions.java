package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class UserActions {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		AppiumDriver driver = CreateDriverSession.initializeAppiumDriver();
		
		By views = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        //Swipe
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

		/* not working for scrolling
		 * driver.executeScript("mobile: swipeGesture", ImmutableMap.of( "elementId",
		 * ((RemoteWebElement) element).getId(), "direction", "up", "percent", 0.80 ));
		 */
        
        //working for scrolling
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
        ".scrollIntoView(new UiSelector().textMatches(\"TextFields\").instance(0))"));

        Thread.sleep(3000);
        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("my text");
        Thread.sleep(3000);
        driver.findElement(editText).clear();
        
        driver.quit();

		

	}

}
