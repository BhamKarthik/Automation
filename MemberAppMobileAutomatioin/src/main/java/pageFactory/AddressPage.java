package pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	public AddressPage() {
	}

	public AddressPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "proceed_to_payment")
	public MobileElement ContinueButton;

	public void ClickContinueButton() {
		ContinueButton.click();
	}

	public void SelectDeliveyslot() {
		ClickContinueButton();

	}
}