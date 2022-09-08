package com.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api_Automation {
@Test
	public static void getCreatData() {
		//Response response=RestAssured.get)("url");==>Get or Delet
		RequestSpecification rs = RestAssured.given();//to add new data inside body==>post/put/patch
		Response responce = rs.post("http://httpbin.org/post");
		//send new data in json==>jsonnobject
		
		JsonObject jo = new JsonObject();//sending the new data
		jo.addProperty("Name", "Habib");
		//send new data==>1)heder data type 2)add json new data inside body
        rs.body(jo.toString());//New data go with body>>mandatory
        rs.header("Content-Type","application/json");//optional
		// Test1
		System.out.println("Status code found = " + responce.statusCode());
		Assert.assertEquals(responce.statusCode(), 200);

		// Test2
		System.out.println("Respond time = " + responce.time());
		Assert.assertTrue(responce.time() > 200);
		// Test3
		System.out.println("Data type = " + responce.contentType());
		Assert.assertTrue(responce.contentType().contains("json"));
		// Test4
		System.out.println(responce.body().print());
		Assert.assertTrue(responce.body() != null);

		// Test5
		JsonPath jp = responce.jsonPath();//read the data
		String originValue = jp.get("origin").toString();
		System.out.println("Origin value check = " + originValue);
		Assert.assertEquals(originValue, "67.250.90.208");

		// Test6

		String hostValue = jp.get("headers.Host").toString();
		System.out.println("Host value check = " + hostValue);
		Assert.assertEquals(hostValue, "httpbin.org");

	}

	public static void main(String[] args) {
		getCreatData();
	}

}
