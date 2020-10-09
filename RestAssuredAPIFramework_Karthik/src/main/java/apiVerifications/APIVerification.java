package apiVerifications;

import static org.testng.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListner;

public class APIVerification extends ExtentReportListner {

	public static void responseCodeValidation(Response response, int statuscode) {
		try {
			assertEquals(response.getStatusCode(),statuscode);
			test.log(LogStatus.PASS, "Test is pass");
			test.log(LogStatus.INFO, "Test is Ended");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.fillInStackTrace());
		}

	}

	public static void responseKeyValidationFromArray(Response response, String title) {
		try {
			JSONArray jarray = new JSONArray(response.getBody().asString());
			for (int i = 0; i < jarray.length(); i++) {			
				JSONObject obj = jarray.getJSONObject(i);
				test.log(LogStatus.PASS, "Validated values is ="+obj.get("title"));	
			}
			test.log(LogStatus.PASS, "Test is pass");
			test.log(LogStatus.INFO, "Test is Ended");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.fillInStackTrace());
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
			test.log(LogStatus.FAIL, ex.fillInStackTrace());
		}
	}

	public static void responsetimeValidation(Response response) {
		try {
			long time = response.time();

			test.log(LogStatus.INFO, "Test is Ended in=" + time);
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.fillInStackTrace());
		}
	}
	public static void responseLog(Response response) {
		try {
			test.log(LogStatus.INFO, "Test is Ended in=" + response.asString());
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex.fillInStackTrace());
		}
	}

}
