package creatRequestByUsingHashMap;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateRequest {
	@Test
	public void CreateReq() {
		HashMap hm = new HashMap();
		hm.put("name", "vivek");
		hm.put("job", "team lead");
				
		given().body(hm).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201).log().all();
		System.out.println(hm);
	}
}
