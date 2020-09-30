package pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import org.openqa.selenium.support.PageFactory;


public class PaymentsPage {
    private AndroidDriver<AndroidElement> driver;
	public PaymentsPage() {
    }
    public PaymentsPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }
    
//@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.view.ViewGroup/android.widget.RadioButton")
    @AndroidFindBy(xpath = "//input[@id='radioButtonCod'][5]")
    public MobileElement FuturepayRadioButton;
    
//input[@text='Future Pay'][@class='android.widget.RadioButton']


    @AndroidFindBy(id = "buttonPay")
    public MobileElement PayButton;
    
    
    @AndroidFindBy(id ="in.pkd.easyday.futuregroup.qa:id/radioButtonCod") 
    public List<MobileElement> AllButton;
    
  
    public void ClickFuturepayRadioButton() {
    	FuturepayRadioButton.click();
    }
    
    public void ClickPayButton() { 
    	PayButton.click();
    }
    public void PlaceFuturepayOrder () {
    	//ClickFuturepayRadioButton();
    	ClickPayButton();
    	
    }
}