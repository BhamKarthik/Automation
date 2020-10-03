package testCases;

import org.testng.annotations.Test;

import baseTest.BaseTest;
import io.restassured.RestAssured;



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
			.assertThat().statusCode(404);
		System.out.println("PDPAPIAutomation done");
		
		//System.out.println("Status_code="+response.getStatusCode());
	}

}
