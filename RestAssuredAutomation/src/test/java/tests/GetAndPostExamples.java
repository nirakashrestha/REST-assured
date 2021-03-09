package tests;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPostExamples {
	
	@Test
	public void testGet()
	{
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("Lindsay","George","Rachel"));
		
	}
	
	
	@Test
	public void testPost() {
		
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("name", "Nirakash");
//		map.put("job", "QA");
//		System.out.println(map);
		
		baseURI = "https://reqres.in/api";
		JSONObject request = new JSONObject();
		request.put("name", "Nirakash");
		request.put("job","QA");
		System.out.println(request.toJSONString());
		
		
		baseURI = "https://reqres.in/api";
		
		given().
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		 post("/users").
		then().
		 statusCode(201).
		 	log().all();
	}

}
