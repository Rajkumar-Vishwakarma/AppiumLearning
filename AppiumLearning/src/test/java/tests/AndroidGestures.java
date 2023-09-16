package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AndroidGestures {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AppiumDriver driver = CreateDriverSession.initializeAppiumDriver();
		// longClickGesture(driver);
		// clickGesture(driver);
		// dragAndDropGesture(driver);
		// pinchOpenGesture(driver);
		// pinchCloseGesture(driver);
		//swipeGesture(driver, "horizontal");
		scrollGesture(driver, "horizontal");
		

	}

	public static void longClickGesture(AppiumDriver driver) {
		By Views = AppiumBy.accessibilityId("Views");
		By DragAndDrop = AppiumBy.accessibilityId("Drag and Drop");
		By longClickByElement = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");

		driver.findElement(Views).click();
		driver.findElement(DragAndDrop).click();
		WebElement longClickElement = driver.findElement(longClickByElement);

		// prefer to use elementId instead of co-ordinates and if you want to use
		// co-ordinates then use relative co-ordinates
		driver.executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) longClickElement).getId(),
//				"x", 209,
//				"y", 543,
						"duration", 1000));
	}

	public static void clickGesture(AppiumDriver driver) {
		By Views = AppiumBy.accessibilityId("Views");
		WebElement viewsElement = driver.findElement(Views);
		driver.executeScript("mobile: clickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) viewsElement).getId()));

	}

	public static void dragAndDropGesture(AppiumDriver driver) {
		By Views = AppiumBy.accessibilityId("Views");
		By DragAndDrop = AppiumBy.accessibilityId("Drag and Drop");
		By longClickByElement = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");

		driver.findElement(Views).click();
		driver.findElement(DragAndDrop).click();
		WebElement longClickElement = driver.findElement(longClickByElement);

		driver.executeScript("mobile: dragGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) longClickElement).getId(), "endX", 609, "endY", 569, "duration", 1000));
	}

	public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
		Thread.sleep(5000);
		driver.executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("left", 200, "top", 470, "width", 600, "height", 600, "percent", 1));

	}

	public static void pinchCloseGesture(AppiumDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("left", 200, "top", 470, "width", 600, "height", 600, "percent", 0.75));

	}

	public static void swipeGesture(AppiumDriver driver, String direction) {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		if (direction.equals("vertical")) {

			WebElement element1 = driver.findElement(AppiumBy.id("android:id/list"));
			driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//					"left", 100, "top", 100, "width", 600, "height", 900,
					"elementId", ((RemoteWebElement) element1).getId(), "direction", "up", "percent", 0.75));

		} else if (direction.equals("horizontal")) {

			driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
			driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
			WebElement element1 = driver.findElement(
					AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView"));
			driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//					"left", 100, "top", 100, "width", 600, "height", 900,
					"elementId", ((RemoteWebElement) element1).getId(), "direction", "left", "percent", 0.75));

		}
	}

	public static void scrollGesture(AppiumDriver driver, String direction) {
		Boolean canScrollMore = true;
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		if (direction.equals("vertical")) {

			WebElement element1 = driver.findElement(AppiumBy.id("android:id/list"));
			while(canScrollMore) {
				canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
//						"left", 100, "top", 100, "width", 300, "height", 500,
						"elementId", ((RemoteWebElement) element1).getId(), 
						"direction", "down", "percent", 0.75));
				System.out.println("Can Scroll More : " + canScrollMore);
			}
			

		} else if (direction.equals("horizontal")) {

			driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
			driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
			WebElement element1;
			
			
			
			int counter = 1;
			while(canScrollMore) {
				String xpathString = String.format(
						"//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[%d]", counter);
				//element1 = driver.findElement(AppiumBy.xpath(xpathString));
				driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
						"left", 400, "top", 250, "width", 280, "height", 150,
//						"elementId", ((RemoteWebElement) element1).getId(), 
						"direction", "right", "percent", 0.75));
				
				System.out.println("Can Scroll More : " + canScrollMore);
				System.out.println(counter);
				counter++;
				
			}
			

		}
		
		
	}
}
