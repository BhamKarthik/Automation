package pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;


public class HomePage {
    public HomePage() {
    }
    public HomePage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    
    
    @AndroidFindBy(id = "home_search_box")
    public MobileElement Searchbox;
    
    @AndroidFindBy(id = "search_src_text")
    public MobileElement Searchboxfield;
    
 // @AndroidFindBy(xpath = "//android.widget.TextView[1][@recourse-id=‘in.pkd.easyday.futuregroup.qa:id/btn_add_to_cart’]")
    
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView")
     public MobileElement ItemAddButton;
  
    @AndroidFindBy(id = "go_to_basket")
    public MobileElement GoToBasket;

    public void EnterInSearchbox(String searchText) {
    	Searchbox.click();
    	Searchboxfield.sendKeys(searchText+"\\n");
    }
    
    public void ClickAddButton() {
    	ItemAddButton.click();
    }
    
    public void ClickGoTobasket() {
    	GoToBasket.click();
    }
    
    public void searchAndSelectItem (String searchText) {
    	
    	EnterInSearchbox(searchText);
    	ClickAddButton();
     }
    
    public void NavigateToCart () {
    	ClickGoTobasket();
    }
}