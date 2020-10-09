package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.getCartPojo;
import utils.ReadExcelSheetData;

public class GetCartAPI extends BaseTest{
	@Test
	public void getCart()  {
		
		RestAssured.baseURI= "http://13.235.191.207:9211/cart/api/v1/";
		RestAssured.basePath="cart/getinfo";
		HeaderConfigs headers=new HeaderConfigs(); 
		ReadExcelSheetData data=new ReadExcelSheetData();
		try {
			data.setMapData("getCart");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cart_key=ReadExcelSheetData.dataMap.get("cart_key");
		int portal_id= Integer.parseInt(ReadExcelSheetData.dataMap.get("portal_id"));
		String cart_type=ReadExcelSheetData.dataMap.get("cart_type");
		int pin_code=Integer.parseInt(ReadExcelSheetData.dataMap.get("pin_code"));
		getCartPojo pojo=new getCartPojo(cart_key,portal_id,cart_type,pin_code);
		ReadExcelSheetData.dataMap.clear();
		Response response=
				RestAssured.given().headers(headers.defaultHeaders())
				.body(pojo)
				.when()
				.post();
	//	APIVerification.responseCodeValidation(response, 200);
	//	APIVerification.responsetimeValidation(response);
		
	}


}
 