package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.BaseClass;
import baseClass.GenericMethods;
import pageFactory.AddressPage;
import pageFactory.CartPage;
import pageFactory.DeliverySlotPage;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import pageFactory.PaymentsPage;

public class TC1VerifyStdDeliveryFPOrderPlacing extends BaseClass{
	
	//public AndroidDriver androidDriver;
	Logger logger=(Logger) LogManager.getLogger(TC1VerifyStdDeliveryFPOrderPlacing.class);
	
	@Test
	public void testCase() throws IOException, InterruptedException
		{
		try {
		ExtentTest extenttest=extent.createTest("testCase","TC1VerifyStdDeliveryOrderPlacing");
		extenttest.log(Status.INFO, "TC1VerifyStdDeliveryFPOrderPlacing started");
		
		logger.info("logger.info");
		logger.warn("logger.warn");
		logger.error("logger.error");
		System.out.println("===============test started================");
		
		
		File classpathRoot = new File(System.getProperty("user.dir"));
		String FilePropertyFilePath=classpathRoot+"/TestData/TestData.properties";
		InputStream input = new FileInputStream(FilePropertyFilePath);
		Properties prop = new Properties();
	    prop.load(input);
	    
	    androidDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		LoginPage loginPage = new LoginPage(androidDriver);
		loginPage.login(prop.getProperty("Phone_Number"),prop.getProperty("OTP"));
		
		HomePage homePage =new HomePage(androidDriver);
		homePage.searchAndSelectItem(prop.getProperty("SKU"));
		homePage.NavigateToCart();
		
		CartPage cartpage =new CartPage(androidDriver);
		cartpage.SelectDeliveyslot();
		
		
		AddressPage addresspage=new AddressPage(androidDriver);
		//addresspage.ClickContinueButton();
		
		
		DeliverySlotPage deliveryslotpage=new DeliverySlotPage(androidDriver);
		deliveryslotpage.SelectPickUpAtStoreDeliveyslot();
		//deliveryslotpage.ClickContinueButton();
		
		GenericMethods genericmethods =new GenericMethods(androidDriver);
    	genericmethods.ScrolltoText(androidDriver,"Future Pay");
    	
		PaymentsPage paymentspage= new PaymentsPage(androidDriver);
		paymentspage.PlaceFuturepayOrder();
		
		
		
		extenttest.log(Status.PASS, " Step");
		}
		catch(Exception ex)
		{
		System.out.println("");
			ex.printStackTrace();
		}
		//
		}	
	
}
