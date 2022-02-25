package com.cg;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01GetRequest {

	@Test
	public void VerifyStatusCode() {

		// specify baseuri
		RestAssured.baseURI = "https://reqres.in/api/users";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// ResponseObject
		Response response = httpRequest.request(Method.GET, "/2");

		// Get the responsebody and print
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);

		// Status Code Validation

		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;

		assertEquals(actualStatusCode, expectedStatusCode);

	}

	@Test
	public void verifyStatusLine() {

		// specify baseuri
		RestAssured.baseURI = "https://reqres.in/api/users";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// ResponseObject
		Response response = httpRequest.request(Method.GET, "/2");

		// validate status line
		String statusLine = response.getStatusLine();
		assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}
