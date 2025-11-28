package crudOperationUsingBddApproach;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ConertStringToJson {
	@Test
	public void readData() {
		baseURI ="https://reqres.in/" ;
		Response resp = when().get("api/unknown/2");
		String data = resp.asString();
		
		JsonPath jp = new JsonPath(data);
		int id = jp.get("data.id");
		String str = jp.get("data.name");
		System.out.println(id);
System.out.println(str);
		
	}
}
