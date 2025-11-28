package createReqByJsonPath;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createJsonObject {
	
	@Test
public void createRequest() {
	JSONObject obj = new JSONObject();
	obj.put("name", "vivek");
	obj.put("job", "student");
	
	given().body(obj).contentType(ContentType.JSON)
	.when().post("https://reqres.in/api/users")
	.then().assertThat().statusCode(201).log().all();
}
}
