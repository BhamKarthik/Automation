package pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;


public class OrderSummary {
    public OrderSummary() {
    }
    public OrderSummary(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "next_action_btn")
    public MobileElement SelectDeliveryButton;
    
  
    public void ClickSelectDeliveryButton() {
    	SelectDeliveryButton.click();
    }
    
    public void SelectDeliveyslot () {
    	
    }
}