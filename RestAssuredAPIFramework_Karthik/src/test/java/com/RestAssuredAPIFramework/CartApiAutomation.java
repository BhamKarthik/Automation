package com.RestAssuredAPIFramework;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PostAPIBuilders;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CartApiAutomation extends BaseTest{
@Test
	public void getCart() {

	
		RestAssured.basePath = "cart/getinfo";
		HeaderConfigs headers=new HeaderConfigs(); 
		PostAPIBuilders builder=new PostAPIBuilders();

		//test.log(LogStatus.INFO,"Test is started");	
		Response response=
				RestAssured.given().headers(headers.defaultHeaders())
				.body(builder.PostRequestBody())
				.when()
				.post();
				APIVerification.responseCodeVerification(response, 200);
				APIVerification.responseKeyValidationFromJson(response, "title");
				APIVerification.responsetimeValidation(response);
	}

}
