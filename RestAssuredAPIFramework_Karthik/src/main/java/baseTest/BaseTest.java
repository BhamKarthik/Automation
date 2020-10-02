package baseTest;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import utils.ExtentReportListner;
import utils.FileAndEnv;

public class BaseTest extends ExtentReportListner{
	@BeforeClass
	public void BaseTest() {
		//RestAssured.baseURI = "13.235.191.207:9211/cart/api/v1/";
		RestAssured.baseURI= FileAndEnv.envAndFile().get("ServerURL");
	}

}
