package crudOperationUsingBddApproach;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import javax.annotation.meta.When;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdatAndFetch {
	@Test
	public void modifyAndRead() {
		baseURI ="https://reqres.in/" ;
		JSONObject obj = new JSONObject();
		obj.put("name", "vivek");
		obj.put("job","QA");
		
		given().body(obj).contentType(ContentType.JSON)
		.when().put("api/users/2").then().assertThat().statusCode(200).log().all();
		
		
		//request to read the data in different format
		
	Response rsp = when().get("api/users/2");
	String data = rsp.getBody().asString();
	String data1 = rsp.asString();
	System.out.println(data1);
	System.out.println("***********************************************************");
	System.out.println(rsp.prettyPeek());
	System.out.println("___________________________________________________________");
	System.out.println(rsp.prettyPrint());
	System.out.println("-----------------------------------------------------------");
	System.out.println(rsp.getStatusCode());
	System.out.println(rsp.getContentType());
	System.out.println(rsp.getTime());
		
		
	}
}
