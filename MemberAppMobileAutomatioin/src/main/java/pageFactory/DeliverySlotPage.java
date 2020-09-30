package pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;


public class DeliverySlotPage {
	  private AndroidDriver<AndroidElement> driver;
    public DeliverySlotPage() {
    }
    public DeliverySlotPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }
    
    @AndroidFindBy(id = "btn_select_delivery")
    public MobileElement SelectDelivery;
    
    @AndroidFindBy(id = "continue_button")
    public MobileElement ContinueButton;
    
    public void SelectDeliveryButton() {
    	SelectDelivery.click();
    }
  
    public void ClickContinueButton() {
    	ContinueButton.click();
    }
    
    public void SelectPickUpAtStoreDeliveyslot () {
    	ClickContinueButton();
    	}
   
}