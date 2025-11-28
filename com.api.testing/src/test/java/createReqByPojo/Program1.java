package createReqByPojo;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import createPojoClass.CreatePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Program1 {
	@Test
	public void m1 () {
		String expectedinfo ="VIVEK";
		baseURI ="https://reqres.in/" ;
		CreatePojo cp = new CreatePojo("VIVEK","manager");
		Response resp = given().body(cp).contentType(ContentType.JSON)
				.when().post("api/users");
		String actualInfo = resp.jsonPath().get("name");
		Assert.assertEquals(actualInfo,expectedinfo);
		System.out.println("assertion pass!!");
		
	}
}
