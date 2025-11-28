package createReqByPojo;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import createPojoClass.CreatePojo;
import io.restassured.http.ContentType;

public class CreateRequest {
	@Test
	public void createReq() {
		CreatePojo cp = new CreatePojo("viek","tester");
		given().body(cp).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201).log().all();
		System.out.println(cp);
		System.out.println("*****************************************************");
	}
	
	@Test
	public void updatReq() {
		CreatePojo cp = new CreatePojo("vivekatama", "qa");
		
		given().body(cp).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201).log().all();
		System.out.println(cp);
	
	}
}
