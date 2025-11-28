package complexDataVlidation;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ComplexDataVlidation {
@Test
	public void complexDataVlidation() {
		String expecteData ="Ramos";
		baseURI ="https://reqres.in/" ;
		Response resp = when().get("api/users");
		List<Object> allData = resp.jsonPath().get("data");
		Iterator<Object> itr = allData.iterator();
		while(itr.hasNext()) {
			String actualInfo = itr.next().toString();
			if(actualInfo.contains(expecteData)) {
				System.out.println(actualInfo);
			}
		}

	}
}
