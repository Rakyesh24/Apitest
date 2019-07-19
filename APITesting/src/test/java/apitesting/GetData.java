package apitesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {

	@Test
	public void test() {

		Response resp = RestAssured.get("http://localhost:3000/posts");

		System.out.println("Status code:" + resp.statusCode());
		System.out.println("------------------------------");
		System.out.println("Header:" + resp.headers());
		System.out.println("------------------------------");
		System.out.println("Time:" + resp.getTime());
		System.out.println("------------------------------");
		System.out.println(resp.getBody().asString());

	}
}
