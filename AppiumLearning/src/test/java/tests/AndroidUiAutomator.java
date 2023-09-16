package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AndroidUiAutomator {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub


		AppiumDriver driver = CreateDriverSession.initializeAppiumDriver();

		WebElement ele = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
		System.out.println("androidUIAutomator text : " + ele.getText());
		ele = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
		System.out.println("androidUIAutomator className : " + ele.getText());
		ele = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
		System.out.println("androidUIAutomator description : " + ele.getText());
		ele = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1);
		System.out.println("androidUIAutomator resourceId : " + ele.getText());


		By byEle = AppiumBy.accessibilityId("Accessibility");
		System.out.println("By element : "+ driver.findElement(byEle).getText());

	}

}
