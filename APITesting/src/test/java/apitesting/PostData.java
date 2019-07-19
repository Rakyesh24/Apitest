package apitesting;

import org.testng.annotations.Test;


import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostData {

	@Test
	public void postTest() {
		
		RequestSpecification request=RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		JsonObject param=new JsonObject();
		
		param.addProperty("id", "5");
		param.addProperty("title", "Jira");
		param.addProperty("author", "Sona");
		
		request.body(param.getAsJsonObject());
		
		Response response=request.post("http://localhost:3000/posts");
		
		int status=response.statusCode();
		
		System.out.println("Status"+status);
		
		
		
		
	}
}
