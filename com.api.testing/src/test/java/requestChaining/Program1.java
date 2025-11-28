package requestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Program1 {
	@Test
	public void requestChaining() {
		baseURI ="https://reqres.in/" ;
		// Request 1 : read all data 
		when().get("api/users").then()
		.assertThat().statusCode(200).log().all();
		System.out.println("-------------------------------------");

		//// Request 2 : read only id number 1
		int id = when().get("api/users").jsonPath().get("data[0].id");
		System.out.println("id :- "+id);
		
		System.out.println("-------------------------------------");

		// Request 3 : read all details about id number 1
		when().get("api/users/"+id).then()
		.assertThat().statusCode(200).log().all();
		
		System.out.println("-------------------------------------");
		
		// Request 4 : delete id no 1 details
		when().delete("api/users/"+id).then()
		.assertThat().statusCode(204).log().all();


	}

}
