package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.awt.print.Printable;
import java.util.Map;

public class Cookies {
	
	//get the cookie info
	@Test(priority=1)
	void testcookeis()
	{
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC","bwiudhe7r93h3e93e8h3e3e3n")
			.log().all();
	}
	
	@Test(priority=2)
	void getcookies()
	{
		
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		
		//get single cookie
		//String Cookie_Val = res.getCookie("AEC");
		//System.out.println("Key value  =======>"+Cookie_Val);
		
		
		//get all cookies
		Map<String,String> cookies_val=res.getCookies();
		
		//System.out.println(cookies_val.keySet());
		
		for(String k:cookies_val.keySet())
		{
			String cookie_val = res.getCookie(k);
			System.out.println(k+" ==>"+cookie_val);
		}
		
	}
	

}
