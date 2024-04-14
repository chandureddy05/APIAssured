package Day6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidator {

	@Test
	public void xmlSchema()
	{
		given()
		
		
		.when()
			.get("https://www.w3schools.com/xml/simple.xml")
		
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("food.xsd"));
		}
}
