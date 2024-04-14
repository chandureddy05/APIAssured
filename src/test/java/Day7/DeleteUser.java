package Day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {

	
	@Test
	public void daleteUser1(ITestContext context){
		
		String id=(String) context.getAttribute("user_id");
		//String id=(String) context.getSuite().getAttribute("user_id");
				
		given()
			.pathParam("id", id)
		
		.when()
			.delete("http://localhost:3000/students/{id}")
			
		.then()
			.statusCode(204)
			.log().all();
	}
}
