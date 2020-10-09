package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.clearCartPojo;
import utils.ReadExcelSheetData;

public class ClearCartAPI extends BaseTest{
	@Test
	public void clearCart()  {

		RestAssured.baseURI= "http://13.235.191.207:9211/cart/api/v1/";
		RestAssured.basePath="cart/clear";
		HeaderConfigs headers=new HeaderConfigs(); 
		ReadExcelSheetData data=new ReadExcelSheetData();
		try {
			data.setMapData("clearCart");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cart_key=ReadExcelSheetData.dataMap.get("cart_key");
		int portal_id= Integer.parseInt(ReadExcelSheetData.dataMap.get("portal_id"));
		String cart_type=ReadExcelSheetData.dataMap.get("cart_type");

		clearCartPojo pojo=new clearCartPojo(cart_key,portal_id,cart_type);
		//clearCartPojo pojo=new clearCartPojo("271237",103,"normal");
		ReadExcelSheetData.dataMap.clear();
		Response response=
				RestAssured.given().headers(headers.defaultHeaders())
				.body(pojo)
				.when()
				.delete();
	//	APIVerification.responseCodeValidation(response, 200);
	//	APIVerification.responsetimeValidation(response);
	}


}
