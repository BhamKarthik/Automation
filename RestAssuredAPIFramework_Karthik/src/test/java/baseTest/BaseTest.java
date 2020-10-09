package baseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import com.relevantcodes.extentreports.LogStatus;
import utils.ExtentReportListner;

@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner{
	@BeforeClass
	public void beforeClass() {
		System.out.println("Base class");
	//	test.log(LogStatus.INFO,"Test has been started");
	//	test.log(LogStatus.PASS,"Test has been Pass");
	//	test.log(LogStatus.INFO,"Test has been Completed");
		//RestAssured.baseURI= "http://13.235.191.207:8102/catalog/api/v1/";
		//RestAssured.baseURI= FileAndEnv.envAndFile().get("ServerURL");
	}

}
