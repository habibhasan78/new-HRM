package com.Api_SDET;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	@Test
	void getweatherDetails() {
		// Specify base URL
		RestAssured.baseURI = "http://httpbin.org/post";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		//Response object
		Response response=httpRequest.request(Method.POST);
		//Print response in cosole window
		String responseBody=response.getBody().asString();
		System.out.println("Response body is :"+responseBody);
		//Status code varification
		int statusacaode=response.getStatusCode();
		System.out.println("Status code is :"+statusacaode);
		Assert.assertEquals(statusacaode,200);
	}

}
