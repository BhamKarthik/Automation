package baseClass;

import java.net.MalformedURLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseClass {
	
	Logger logger=(Logger) LogManager.getLogger(BaseClass.class);
		public static AndroidDriver<AndroidElement> androidDriver;
		public static Properties prop = new Properties();
	    ExtentHtmlReporter htmlReporter;
		public ExtentReports extent;
		
		  @BeforeSuite
		  public void beforeSuite() {
		    System.out.println("BeforeSuite");
		    ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter("Extent.html");
		    extent =new ExtentReports();
		    extent.attachReporter(htmlReporter);
		  		  }

		  @BeforeTest
		  public void beforeTest() {
		    System.out.println("BeforeTest");
		  }

		  //@SuppressWarnings("unchecked")
		@Parameters({ "deviceName", "udid", "platformVersion", "platformName" })
		  @BeforeClass
		  public void beforeClass(String deviceName,String udid,String platformVersion,String platformName) throws MalformedURLException, InterruptedException {
			  try {
	//		androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    AppSetup appSetup=new AppSetup();
		    androidDriver= appSetup.appSetup(androidDriver, deviceName, udid, platformVersion, platformName);
		    System.out.println("Before Class");
			  }
			  catch(Exception ex){
			  ex.printStackTrace();
			  }
		  }

		  @BeforeMethod
		  public void beforeMethod() {
		    System.out.println("BeforeMethod");
		  }

		  @AfterMethod
		  public void afterMethod() {
		    System.out.println("AfterMethod");
		  }

		  @AfterClass
		  public void afterClass() {
		    System.out.println("AfterClass");
		  }

		  @AfterTest
		  public void afterTest() {
		    System.out.println("AfterTest");
		  }

		  @AfterSuite
		  public void afterSuite() {
			  extent.flush();
		    System.out.println("AfterSuite");
		  }
	
}
