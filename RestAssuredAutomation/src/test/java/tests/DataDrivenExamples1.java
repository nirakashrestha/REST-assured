package tests;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples1 extends DataForTests {	


	//@Test(dataProvider = "DataToPost")	
	public void testPost(String firstName, String lastName, int subjectId) {

		JSONObject request = new JSONObject();

		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);

		baseURI = "http://localhost:3000/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type","application/json").
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();

	}
	
	@DataProvider(name = "DataToDelete")
	public Object[] dataForDelete() {
		
		return new Object[] {6,7 };
	}
	
	//@Test(dataProvider = "DataToDelete")
	public void testDelete(int userid)
	{
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/"+userid).
		then().
			statusCode(200);
		
		
	}
	
	
	@Parameters({"userID"})
	@Test
	public void testDelete2(int userid)
	{
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/"+userid).
		then().
			statusCode(200);
		
	}
}
