package com.api;

import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAutomation {

	public static void getCreatData() {
		
		RequestSpecification rs=RestAssured.given();
		Response responce= rs.post("http://httpbin.org/post");
		
		
		JsonObject jo=new JsonObject();
		jo.addProperty("name", "habib");
		rs.body(jo.toString());
		
		//test1
	   System.out.println("Status code is found :"+responce.statusCode());
	   Assert.assertEquals(responce.statusCode(), 200);
         //test2
	   System.out.println("Response time :"+responce.time());
	   Assert.assertTrue(responce.time()>800 );
	  // test3
	   System.out.println("Header check contain type :"+responce.contentType());
	   Assert.assertTrue(responce.contentType().contains("json"));
	   //test4
	   System.out.println(responce.body().print());
	   Assert.assertTrue(responce.body()!=null);
	   
	   //test5
	   JsonPath jp= responce.jsonPath(); 
	 String originValue=jp.get("origin").toString();
	 System.out.println("This is origin value :"+originValue);
	 Assert.assertEquals(originValue, "67.250.90.208");
	   //test6
	 
	 String hostValue=jp.get("headers.Host").toString();
	 System.out.println("This is host  value :"+hostValue);
	 Assert.assertEquals(hostValue, "httpbin.org");
	 
	}

	public static void main(String[] args) {
		getCreatData();
	}
	
}
