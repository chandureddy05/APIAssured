package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XMLParsing {
	
	//@Test
	public void testXMLParse()
	{
		//http://restapi.adequateshop.com/api/Traveler?page=1
		//https://www.w3schools.com/xml/simple.xml
		
		//Approach 1
		/*given()
			
		.when()
			.get("https://www.w3schools.com/xml/simple.xml")
		.then()
			.statusCode(200)
			.body("breakfast_menu.food[0].name",equalTo("Belgian Waffle"));
		*/
		
		//Approach 2
		Response res=given()
			
		.when()
			.get("https://www.w3schools.com/xml/simple.xml");
		
		Assert.assertEquals(res.statusCode(), 200);
		
		String menu=res.xmlPath().get("breakfast_menu.food[2].name").toString();
		
		Assert.assertEquals(menu,"Berry-Berry Belgian Waffle");
			
		
	}

	@Test
	public void xmlParsedata()
	{
		
		Response res=given()
			
		.when()
			.get("https://www.w3schools.com/xml/simple.xml");
		
		//XML path object
		//toString - convert the data into string
		//asString - convert entire response into string
		
		XmlPath xmloj=new XmlPath(res.asString());
		
		//verify total no of foods
		//List<String> foods = xmloj.getList("breakfast_menu.food");
		//System.out.println(foods.size());
		
		List<String> foods1 = xmloj.getList("breakfast_menu.food.name");
		boolean Status=false;
		for(String fd:foods1)
		{
			//System.out.println(fd);
			if(fd.equals("FrenchToast"))
			{
				Status = true;
				break;
				
			}
			
		}
		Assert.assertEquals(Status, true);
	}
}
