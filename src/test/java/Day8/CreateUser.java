package Day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CreateUser {
	
	@Test
	public void CreateUser1(ITestContext context){
		
		//Random rData = new Random();
		
		JSONObject data = new JSONObject();
		
		data.put("name","Hari");
		data.put("Gender","Male");
		data.put("email","test@gmail.com");
		data.put("status","active");
		
		String bearerToken = "2f76bb8c22cc5feb8d620e631d031cbc81ccd9904d11346202719407c26f6ee4";
		
		int id=given()
			.headers("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())			
		
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
			
			System.out.println(id);
			//context.setAttribute("user_id", id);
			context.getSuite().setAttribute("user_id", id);
	}

}
