package apitesting;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutData {

	@Test
	public void putTest() {
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		JsonObject param = new JsonObject();

		param.addProperty("id", "3");
		param.addProperty("title", "QTP course");
		param.addProperty("author", "Abhi");

		request.body(param.getAsJsonObject());

		Response response = request.put("http://localhost:3000/posts/3");

		int status = response.statusCode();

		System.out.println("Status:" + status);
	}
}
