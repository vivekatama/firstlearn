package crudOperationUsingBddApproach;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FetchDataUsingJsonPath {

	@Test
	public void fetchUsingJsonPath() {
		baseURI ="https://reqres.in/" ;
		Response resp = when().get("api/unknown/2");
		String obj = resp.jsonPath().get("data.name");
		System.out.println(obj);
				
	}
	
}
