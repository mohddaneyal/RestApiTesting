package com.cg;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_HeaderTest {

	@Test
	public void getAllHeader() {

		// specify baseuri
		RestAssured.baseURI = "https://reqres.in/api/users";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// ResponseObject
		Response response = httpRequest.request(Method.GET, "/2");
		
		// Get All header
		
	      Headers allheader = response.headers();
	      
	      for(Header h : allheader)
	    	  System.out.println("Haeder Name :"+h.getName()+"  Header value :"+h.getValue());
	      
	      String actualHeaderContent = response.header("Content-Type");
	      
	      String expectedHeaderContent = "application/json; charset=utf-8";
	      
	      assertEquals(actualHeaderContent, expectedHeaderContent);
	      
	      

	}

}
