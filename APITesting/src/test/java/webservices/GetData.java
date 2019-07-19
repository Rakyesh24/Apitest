package webservices;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetData {

	@Test
	public void getTest() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get("https://www.google.co.in");
		int status = response.statusCode();
		System.out.println("Status: " + status);
	}
}
