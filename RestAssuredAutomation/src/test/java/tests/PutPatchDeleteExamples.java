package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PutPatchDeleteExamples {

	@Test
	public void testPut() {

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
		put("/users").
		then().
		statusCode(200).
		log().all();
	}

	@Test
	public void testPatch() {

		JSONObject request = new JSONObject();
		request.put("name", "Nirakash");
		request.put("job","QA");
		System.out.println(request.toJSONString());


		baseURI = "https://reqres.in/api/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("api/users/2").
		then().
		statusCode(200).
		log().all();
	}
	
	@Test
	public void testDelete() {

		baseURI = "https://reqres.in/api/";

		when().
		delete("api/users/2").
		then().
		statusCode(204).
		log().all();
	}

}
