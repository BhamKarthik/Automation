package baseClass;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class GenericMethods {
	 private AndroidDriver<AndroidElement> driver;
	 public GenericMethods(AndroidDriver<AndroidElement> driver) {
         PageFactory.initElements(new AppiumFieldDecorator(driver), this);
         this.driver = driver;
     }
     
	 public void ScrolltoText(AndroidDriver<AndroidElement> driver,String Name) {
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"in.pkd.easyday.futuregroup.qa:id/payment_recycler\"))."
		 		+ "getChildByText(new UiSelector().className(\"android.widget.RadioButton\"),\"Future Pay\")")).click();
		
    }

}