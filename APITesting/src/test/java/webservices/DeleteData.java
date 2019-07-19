package webservices;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteData {

	@Test
	public void postData() {
		RequestSpecification request = RestAssured.given();

		Response respone = request.delete("http://localhost:3000/posts/KWpP2iz");

		System.out.println(respone.statusCode());
	}
}
