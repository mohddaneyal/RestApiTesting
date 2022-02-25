package com.cg;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC05_BasicAuthentication {

	@Test
	public void basicAuthenticationTest() {

//		// specify baseuri
//		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
//		
//		// Baisc Authentication
//		PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
//		basicAuth.setUserName("admin");
//		basicAuth.setPassword("test");
//		
//		RestAssured.authentication = basicAuth;
//		
//		
//		// Request Object
//		RequestSpecification httpRequest = RestAssured.given();
//
//		// ResponseObject
//		Response response = httpRequest.request(Method.GET, "/");

	}
}
