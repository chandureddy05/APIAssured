package Day8;

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
		
		//int id=(Integer) context().getAttribute("user_id");
		int id=(Integer) context.getSuite().getAttribute("user_id");
		
		JSONObject data = new JSONObject();
		
		data.put("name","Mani");
		data.put("Gender","Female");
		data.put("email","mani@gmail.com");
		data.put("status","inactive");	
		
		String bearerToken = "2f76bb8c22cc5feb8d620e631d031cbc81ccd9904d11346202719407c26f6ee4";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")

		.then()
			.statusCode(200)
			.log().all();
			
	}
}
