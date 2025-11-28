package createReqByPojo;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import createPojoClass.CreatePojo1;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PostOperationUsingPojo {

	@Test
	public void loginOperation() {
		String expectedinfo ="vivekatama@gmail.com";
		CreatePojo1 cp = new CreatePojo1("vivek", "vivekatama@gmail.com", "vivek@123");
		
		Response resp = given().body(cp).contentType(ContentType.JSON)
				.when().post("https://reqres.in/api-docs/#/default/post_login");
		String actualInfo = resp.jsonPath().get("email");
		Assert.assertEquals(actualInfo,expectedinfo);
		System.out.println("assertion pass!!");
		
		
	}
}

