package com.RestAssuredAPIFramework;

import org.testng.annotations.Test;

import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class PDPAPIAutomation  extends BaseTest{
	
	

	@Test
	public void getPDP() {
		
	
		RestAssured.basePath="product-detail/103/article/";
		//String article_scode="000050012616361013";
		
		RestAssured.given()
			.pathParam("article_scode","000050012616361013")
		.when()
			.get("/{article_scode}")
		.then()
			.assertThat().statusCode(200);
		
		//System.out.println("Status_code="+response.getStatusCode());
	}

}
