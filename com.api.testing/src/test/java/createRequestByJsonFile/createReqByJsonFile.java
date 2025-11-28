package createRequestByJsonFile;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.junit.Test;

import io.restassured.http.ContentType;
public class createReqByJsonFile {
	@Test
public void createReq() {
	File f = new File("C:\\AutomationProgram\\com.api.testing\\details.json");
	
	given().body(f).contentType(ContentType.JSON)
	.when().post("https://reqres.in/api/users")
	.then().assertThat().statusCode(201).log().all();
}
}
