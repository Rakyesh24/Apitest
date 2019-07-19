package webservices;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostData {

	@Test
	public void postData() {
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		JsonObject param = new JsonObject();
		param.addProperty("id", "5");
		param.addProperty("title", "QA");
		param.addProperty("author", "Harry Potter");

		request.body(param.getAsJsonObject());

		Response respone = request.post("http://localhost:3000/posts");

		System.out.println(respone.statusCode());
	}
}
