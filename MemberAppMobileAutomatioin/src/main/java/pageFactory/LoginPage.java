package pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.Properties;

import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    public LoginPage() {
    }
    public LoginPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "login_button")
    public MobileElement MemberLoginButton;
    
    @AndroidFindBy(xpath = "//android.widget.Button")
    public MobileElement ContinueToastMessage;
    
    @AndroidFindBy(id = "mobile_number_editText")
    public MobileElement Mobile_Number_Text;
    
    @AndroidFindBy(id = "otp_generate_button")
    public MobileElement otp_generate_button;
    
    @AndroidFindBy(id = "otp_edittext")
    public MobileElement enterOTPtext;
    
    @AndroidFindBy(id = "otp_verify_button")
    public MobileElement VerifyOTPButton;
    
    @AndroidFindBy(id = "resend_otp_TextView")
    public MobileElement ResendOTPLink;

    
    public void clickMemberLoginButton() {
    	MemberLoginButton.click();
    }
    public void clickContinueToastMessage() {
    	ContinueToastMessage.click();
    }
    
    public void EnterMobileNumberText(String PhonoNo) {
    	Mobile_Number_Text.sendKeys(PhonoNo);
    }
    
    public void clickOTPGenerateButton() {
    	otp_generate_button.click();
    }
    
    public void EnterenterOTPText(String OTP) {
    	enterOTPtext.sendKeys(OTP);
    }
    
    public void ClickVerifyOTPButton() {
    	VerifyOTPButton.click();;
    }
    
    public void ClickResendOTPLink() {
    	ResendOTPLink.click();;
    }
    
    
    
    public void login (String PhonoNo,String OTP) {
        clickMemberLoginButton();
        try
        {
        //	clickContinueToastMessage();
        }
        finally {
        	
        	EnterMobileNumberText(PhonoNo);
        	clickOTPGenerateButton();
        	EnterenterOTPText(OTP);
        	ClickVerifyOTPButton();
        }
    }
}