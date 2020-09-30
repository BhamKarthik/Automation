package pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;


public class CartPage {
    private AndroidDriver<AndroidElement> driver;
    public CartPage() {
    }
    public CartPage(AndroidDriver<AndroidElement> driver) {
    	
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }
    
    @AndroidFindBy(id = "btn_select_delivery")
    public MobileElement SelectDeliveryButton;
    
    @AndroidFindBy(xpath = "//android.widget.Button[1]")
    public MobileElement Canclebutton;
    
    @AndroidFindBy(id = "store_pickup")
    public MobileElement PickUpAtStore;
    
  
    public void ClickSelectDeliveryButton() {
    	SelectDeliveryButton.click();
    }
    
    public void MembershipWarningCancle() {
    	Canclebutton.click();
    	
    }
    public void SelectPickUpAtStore(){
    	PickUpAtStore.click();
    }
    public void SelectDeliveyslot () {
    	ClickSelectDeliveryButton();
    	MembershipWarningCancle();
    	SelectPickUpAtStore();
    	
    }
}