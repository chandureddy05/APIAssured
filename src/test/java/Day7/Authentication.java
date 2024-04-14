package Day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Authentication {
	
	//Authentications - Basic, Digest, Preemptive, Bearer token, OAuth 1.0, OAuth2.0, API Key
	
	@Test(priority=1)
	void Basic()
	{
		
		given()
			.auth().basic("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
		
		
	}
	
	@Test(priority=2)
	void digest()
	{
		
		given()
			.auth().digest("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
		
		
	}
	
	@Test(priority=3)
	void preemptive()
	{
		
		given()
			.auth().preemptive().basic("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
		
		
	}
	
	@Test(priority=4)
	void bearerToken()
	{
		String brtoken="2f76bb8c22cc5feb8d620e631d031cbc81ccd9904d11346202719407c26f6ee4";
		given()
			.header("Authorization","Bearer "+brtoken)
		
		.when()
			.get("https://api.github.com/user/repos")
			
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
		
		
	}
	
	//@Test(priority=5)
	void oAuth1()
	{
		
		given()
			//.oauth("consumerKey","consumerToken","accessToken","tokenSecrate")
		
		.when()
			.get("https://api.github.com/user/repos")
			
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
		
		
	}
	
	//@Test(priority=6)
	void oAuth2()
	{
		
		given()
		//.oauth2("token")
		
		.when()
			.get("https://api.github.com/user/repos")
			
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
		
		
	}
	
	//@Test(priority=7)
	void APIToken()
	{
		
		//Method 1
		//https://api.openweathermap.com/data/2.5/forecast/daily?q=Delhi&units=metrics&cnt=7
		given()
			.queryParam("appid", "key")
		
		.when()
			.get("https://api.openweathermap.com/data/2.5/forecast/daily?q=delhi&units=metrics&cnt=7")
			
		.then()
			.statusCode(200)
			.log().all();
		
		//Method2
		
		given()
			.queryParam("appid", "key")
			.pathParam("myid", "data/2.5/forecast/daily")
			.queryParam("q", "delhi")
			.queryParam("units", "metrics")
			.queryParam("cnt", "7")
	
		.when()
			.get("https://api.openweathermap.com/data/{myid}")
			
		.then()
			.statusCode(200)
			.log().all();
	}
}
