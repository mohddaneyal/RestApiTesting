package com.cg;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02PostReqUest {
	@Test
	public void createUserVerification() {
		
		

		// specify baseuri
		RestAssured.baseURI = "https://reqres.in/api/users";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Request Parameter : Request payload senf with POST request
		
		JSONObject requestParameter = new JSONObject();
		
		requestParameter.put("name", "Daneyal");
		requestParameter.put("job", "Facilitator");
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestParameter.toString());

		// ResponseObject
		Response response = httpRequest.request(Method.POST);

		// Get the responsebody and print
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		// Status Code Validation

		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 201;

		assertEquals(actualStatusCode, expectedStatusCode);
		
		// verify id in body
		
		String id = response.jsonPath().get("id");
		
		assertNotNull(id);

	}
}
