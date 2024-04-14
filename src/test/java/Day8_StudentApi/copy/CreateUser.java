package Day8_StudentApi.copy;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Random;

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
		data.put("location","bellary");
		data.put("email","test1@gmail.com");
		
				
		String id=given()
			.contentType("application/json")
			.body(data.toString())			
		
		.when()
			.post("http://localhost:3000/students")
			.jsonPath().getString("id");
			
			System.out.println(id);
			context.setAttribute("user_id", id);
			//context.getSuite().setAttribute("user_id", id);
	}

}
