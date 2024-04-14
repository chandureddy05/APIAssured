package Day3;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Header {
	
	
	//@Test
	void testHeader()
	{
		given()
		
		.when()
			.get("https://www.google.com/")	
		
		.then()
			
			.header("Server", "gws");
				
	
	}
	
	@Test(priority=2)
	void getHeaders()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.com/");		
		
		//get single Header
		//String Header_Val = res.getHeader("Server");
		//System.out.println("Header value  =======>"+Header_Val);
		
		//get all headers
		Headers myheader=res.getHeaders();
		
		for(io.restassured.http.Header hd:myheader)
		{
			
			System.out.println(hd+" ====>"+myheader);
		}
	}
	
	
	

}
