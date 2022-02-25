package com.cg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC06_ExtractingValuesFromResponse {

	@Test
	public void exttractValuesNodes() {
		// specify baseuri
		RestAssured.baseURI = "https://reqres.in/api/users";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// ResponseObject
		Response response = httpRequest.request(Method.GET, "/2");
		
		JsonPath jsonPath =  response.jsonPath();
		
//		System.out.println(jsonPath.get("data.id"));
//		System.out.println(jsonPath.get("data.email"));
//		System.out.println(jsonPath.get("data.first_name"));
//		System.out.println(jsonPath.get("data.last_name"));
//		System.out.println(jsonPath.get("data.avatar"));
	}
}
