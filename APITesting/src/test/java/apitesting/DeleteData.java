package apitesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteData {

	@Test
	public void postTest() {

		RequestSpecification request = RestAssured.given();

		Response response = request.delete("http://localhost:3000/posts/5");

		int status = response.statusCode();

		System.out.println("Status" + status);

	}
}
