package baseClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppSetup {

	//static final LoggerConfig logger = Logger.getLogger(AppSetup.class);
	@SuppressWarnings("rawtypes")
	//private static AndroidDriver androidDriver;
	public  AndroidDriver appSetup(AndroidDriver androidDriver,String deviceName,String udid,String platformVersion,String platformName) throws MalformedURLException, InterruptedException 
	{
		//AndroidDriver androidDriver1 = null;
		//public  AndroidDriver appSetup(String deviceName,String udid,String platformVersion,String platformName) throws MalformedURLException, InterruptedException {

		try {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "Builds");
			File[] listOfFiles = appDir.listFiles();
			
			
			File app = new File(appDir, listOfFiles[0].getName());

			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("udid", udid); 
			capabilities.setCapability("platformVersion", platformVersion);
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("appPackage", "in.pkd.easyday.futuregroup.qa");
			capabilities.setCapability("appActivity", "future.feature.main.MainActivity"); 
			//capabilities.setCapability("fullReset","true");
			//capabilities.setCapability("noResetValue","false");
			capabilities.setCapability("app", app.getAbsolutePath());
			

			androidDriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			

		}
		catch(Exception exp)
		{
			exp.printStackTrace();  
		}
		return androidDriver;

	}
}