package Day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;


public class JSONSchemaValidator {
	
	@Test
	public void Jsonschema()
	{
		given()
		
		
		.when()
			.get("http://localhost:3000/students")
		
		.then()
			//.assertThat().body(JSONSchemaValidator..matchesjsonschemainclasspath("Jsonschemafile.json"));
		.statusCode(200);
		
		}
	

}
