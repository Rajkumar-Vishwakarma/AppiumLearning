package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AndroidFindElements {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub


		AppiumDriver driver = CreateDriverSession.initializeAppiumDriver();

		WebElement ele = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
		System.out.println("accessibilityId : "+ele.getText());
		ele = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
		System.out.println("resource id : "+ele.getText());
		ele = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
		System.out.println("className : "+ele.getText());
		ele = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
		System.out.println("xpath : "+ele.getText());



	}

}
