package com.cg;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_BodyAuthentication {
	@Test
	public void getBodyData() {

		// specify baseuri
		RestAssured.baseURI = "https://reqres.in/api/users";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// ResponseObject
		Response response = httpRequest.request(Method.GET, "/2");

		// Get the responsebody and print
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		// id verification 

		assertEquals(responseBody.contains("id"), true);

	}
}
