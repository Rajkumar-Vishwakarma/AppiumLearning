package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AndroidFindByAnnotation {

	// @FindBy(xpath = "//*[@text=\"Accessibility\"]")
	@AndroidFindBy(xpath = "//*[@text=\"Accessibility\"]")
	@iOSXCUITFindBy(accessibility = "Accessibility")
	private static WebElement findByEle;
	// use @AndroidFindBy and @iOSXCUITFindBy PageFactory methods if testing native
	// app on both android and ios and an element
	// cant be located with same locator on both platforms
	// if the app is hybrid then you can simply use FindBy

	public AndroidFindByAnnotation(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AppiumDriver driver = CreateDriverSession.initializeAppiumDriver();

		AndroidFindByAnnotation androidFindByAnnotation = new AndroidFindByAnnotation(driver);
		System.out.println(findByEle.getText());

	}

}
