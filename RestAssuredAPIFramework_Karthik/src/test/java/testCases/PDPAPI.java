package testCases;
import org.testng.annotations.Test;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PDPAPI  extends BaseTest{
	@Test
	public void getPDP()
	{
		RestAssured.baseURI= "http://13.235.191.207:8102/catalog/api/v1/";
		RestAssured.basePath="product-detail/103/article/";
		HeaderConfigs headers=new HeaderConfigs();
		String key="000050012616361013";	
		Response response=
				RestAssured.given().headers(headers.defaultHeaders())
				.pathParam("article_scode","000050012616361013")
				.when()
				.get("/{article_scode}");
	//	APIVerification.responseCodeValidation(response, 200);
	//	APIVerification.responsetimeValidation(response);
	//	APIVerification.responseKeyValidationFromJson(response, key);
	//	APIVerification.responseLog(response);
	}

}
