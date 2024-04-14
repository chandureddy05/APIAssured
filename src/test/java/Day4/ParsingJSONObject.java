package Day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONObject {

	//@Test(priority=1)
	public void parsingJsondata(){
		
		//Approach 1
		given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/journels")
			
		.then()
			.statusCode(200)
			//.log().all()
			.body("journels[2].title", equalTo("pig"));
		
		/*Response res = given()
		.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/journels");
		
			Assert.assertEquals(res.statusCode(), 200);
			
			String title = res.jsonPath().get("journels[3].title").toString();
			Assert.assertEquals(title, "pig");*/
			
					
			
	}
	
	@Test(priority=2)
	public void parsingJSONresponsedynamically(){
		
	Response res = given()
		.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/journels/");
		
			//JSON Object class
			JSONObject jo=new JSONObject(res.asString());  //coverting response to json objectss
			
			/*for(int i=0;i<jo.getJSONArray("journels").length();i++)
			{
				String jounelstTitles = jo.getJSONArray("journels").getJSONObject(i).get("name").toString();
				System.out.println(jounelstTitles);
			}*/
			
			
			boolean status =false;
			for(int i=0;i<jo.getJSONArray("journels").length();i++)
			{
				String jounelstTitles = jo.getJSONArray("journels").getJSONObject(i).get("name").toString();
				if(jounelstTitles.equals("sir"))
				{
					status=true;
					break;
				}
			}
					
			Assert.assertEquals(status, true);
			
			//validate the price of the books
			/*double totalprice=0;
			for(int i=0;i<jo.getJSONArray("journels").length();i++)
			{
				String price = jo.getJSONArray("journels").getJSONObject(i).get("price").toString();
				
				totalprice=totalprice+Double.parseDouble(price);*/
								
			}
			/*System.out.println(totalprice);
			Assert.assertEquals(totalprice, 99);*/
	}
