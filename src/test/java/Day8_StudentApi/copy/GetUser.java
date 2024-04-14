package Day8_StudentApi.copy;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	@Test
	public void GetUser1(ITestContext context){
		
		String id=(String) context.getAttribute("user_id");
		//String id=(String) context.getSuite().getAttribute("user_id");
				
		given()
			.contentType("application/json")
			.pathParam("id", id)		
		
		.when()
			.get("http://localhost:3000/students/{id}")

		.then()
			.statusCode(200)
			.log().all();
			
	}
}
