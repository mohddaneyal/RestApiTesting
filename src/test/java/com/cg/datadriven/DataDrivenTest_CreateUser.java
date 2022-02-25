package com.cg.datadriven;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_CreateUser {

	@Test(dataProvider = "userDataProvider")
	public void crearteNewUser(String name, String job) {
		// specify baseuri
		RestAssured.baseURI = "https://reqres.in/api/users";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Request Parameter : Request payload senf with POST request

		JSONObject requestParameter = new JSONObject();

		requestParameter.put("name", name);
		requestParameter.put("job", job);

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParameter.toString());

		// ResponseObject
		Response response = httpRequest.request(Method.POST);

		// Get the responsebody and print
		String responseBody = response.getBody().asString();
		
		// validation
		
		// validate status code
		int actualStatusCode = response.statusCode();
		System.out.println("STATAUS CODE ==:"+actualStatusCode);
		assertEquals(actualStatusCode, 201);
		
		// assert body
		
		assertEquals(responseBody.contains("name"), true);
		assertEquals(responseBody.contains("job"), true);
		assertEquals(responseBody.contains("id"), true);		
		
	}

	// data provider method
	@DataProvider(name = "userDataProvider")
	public String[][] userData() throws IOException {

		//String data[][] = { { "Daneyal", "facilitator" }, { "Ankit", "Developer" }, { "Amit", "Tester" } };
		
		String xlPath = "C:\\Users\\mhasanla\\eclipse-workspace\\RestAssuredAPITesting\\src\\test\\java\\com\\cg\\datadriven\\userData.xlsx";
		//String xlPath = System.getProperty("user.dir")+"/RestAssuredAPITesting/src/test/java/com/cg/datadriven/userData.xlsx";
		
		int rowcount = XLUtils.getRowCount(xlPath, "sheet1");
		int colcount = XLUtils.getCellCount(xlPath, "sheet1", 1);
		
		String userData [][]= new String[rowcount][colcount];
		
		for(int i=1; i<=rowcount ;i++) {
			for(int j=0; j<colcount; j++) {
				userData[ i -1 ][j] = XLUtils.getCellData(xlPath, "sheet1", i, j);
			}
		}
		
		return userData;
	}

}
