package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParam {

	//https://reqres.in/api/users?page=2&id=5
	@Test
	void pathandquerypara()
	{
		
		given()
			.pathParam("mypath", "users")
			.queryParam("page", "2")
			.queryParam("id", "6")
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
		
		
	}
}
