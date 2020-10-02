package apiVerifications;

import static org.testng.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListner;

public class APIVerification extends ExtentReportListner {

	public static void responseCodeVerification(Response response, int statuscode) {
		try {
			assertEquals(statuscode, response.statusCode());
			test.log(LogStatus.PASS, "Successfully " + response.statusCode());
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "status code" + response.statusCode());
		}

	}

	public static void responseKeyValidationFromArray(Response response, String title) {
		try {
			JSONArray jarray = new JSONArray(response.getBody().asString());
			for (int i = 0; i < jarray.length(); i++) {
				System.out.println(jarray.get(i));
			}
			test.log(LogStatus.PASS, "Test is pass");
			test.log(LogStatus.INFO, "Test is Ended");
		} catch (Exception ex) {
		}
	}

	public static void responseKeyValidationFromJson(Response response, String key) {
		try {
			JSONObject jSon = new JSONObject(response.getBody().asString());
			if (jSon.has(key) && jSon.get(key)!=null) {
				test.log(LogStatus.PASS, "Test is pass");
				test.log(LogStatus.INFO, "Test is Ended");
			}
		} catch (Exception ex) {
		}
	}

	public static void responsetimeValidation(Response response) {
		try {
			long time = response.time();

			test.log(LogStatus.INFO, "Test is Ended in=" + time);
		} catch (Exception ex) {
		}
	}

}
