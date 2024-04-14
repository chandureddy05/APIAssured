package Day8_StudentApi.copy;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdateUser {

	@Test
	public void updateUser1(ITestContext context){
		
		String id=(String) context.getAttribute("user_id");
		//String id=(String) context.getSuite().getAttribute("user_id");
		
		JSONObject data = new JSONObject();
		
		data.put("name","Mani");
		data.put("location","bombay");
		
		
		
		given()
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
		
		.when()
			.put("http://localhost:3000/students/{id}")

		.then()
			.statusCode(200)
			.log().all();
			
	}
}
