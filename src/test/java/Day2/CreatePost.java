package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CreatePost {
	
	int id;
	String id1;
	//Hashmap
	@Test(priority=1)
	public void PostusingHasMap(ITestContext context)
	{
		HashMap data=new HashMap();
		
		data.put("location", "hyd");
		data.put("name", "Michael");
		
		
		String courseArr[] = {"c","c++"};
		data.put("courses", courseArr);
		
		Response id=given()		
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students");
		System.out.println(id);
			/*.jsonPath().getInt("id");
			
			context.setAttribute("user_id", id);*/
			
		/*.then()
			.statusCode(201)
			.body("name",equalTo("Michael"))
			.body("location",equalTo("hyd"))
			.body("courses[0]",equalTo("c"))
			.body("courses[1]",equalTo("c++"))
			//.header("Content-Type", "application/json; charset=utf-8")
			.log().all();*/
		
		context.setAttribute("user_id", id);
	}
	
	//@Test(priority=2)
	public void delete(ITestContext context)
	{
		int id = (Integer) context.getAttribute("user_id");
		when()
			.delete("http://localhost:3000/students/{id}")
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
	
		//Org.json
		//@Test(priority=1)
		public void Postusingorgjson()
		{
			JSONObject data=new JSONObject();
			
			data.put("name", "smith");
			data.put("location", "france");
			
			String courseArr[] = {"c","java"};
			data.put("courses", courseArr);
			
			given()		
				.contentType("application/json")
				.body(data.toString())
			
			.when()
				.post("http://localhost:3000/students")
				
			.then()
				.statusCode(201)
				.body("name",equalTo("smith"))
				.body("location",equalTo("france"))
				.body("courses[0]",equalTo("c"))
				.body("courses[1]",equalTo("java"))
				//.header("Content-Type", "application/json; charset=utf-8")
				.log().all();
			
			
		}
		
		//@Test(priority=2)
		public void deleteorgjson()
		{
			given()
			
			.when()
				.delete("http://localhost:3000/students/45b3")
			.then()
				.statusCode(200)
				.log().all();
			
			
		}
		
				//POJO
				//@Test(priority=1)
				public void Postusingpojo()
				{
					POJO_postreq data=new POJO_postreq();
					
					data.setName("scott");
					data.setLocation("france");
					
					String coursesarr[]={"c","java"};
					data.setCourses(coursesarr);
					
					id1=given()		
						.contentType("application/json")
						.body(data)
					
					.when()
						.post("http://localhost:3000/students")
						.jsonPath().getString("id1");
						
					/*.then()
						.statusCode(201)
						.body("name",equalTo("smith"))
						.body("location",equalTo("france"))
						.body("courses[0]",equalTo("c"))
						.body("courses[1]",equalTo("java"))
						.header("Content-Type", "application/json; charset=utf-8")
						.log().all();*/
					
					
				}
				
				//@Test(priority=2)
				public void deletepojo()
				{
					given()
					
					.when()
						.delete("http://localhost:3000/students/"+id1)
					.then()
						.statusCode(200)
						.log().all();
					
					
				}
				
				
				//externl json
				//@Test(priority=1)
				public void Postusinexternaljson() throws FileNotFoundException
				{
					
					File fl=new File(".\\body.json");
					
					FileReader fr=new FileReader(fl);
					
					JSONTokener jt=new JSONTokener(fr);
					
					JSONObject data=new JSONObject(jt);
					
					given()		
						.contentType("application/json")
						.body(data.toString())
					
					.when()
						.post("http://localhost:3000/students")
						
					.then()
						.statusCode(201)
						.body("name",equalTo("smith"))
						.body("location",equalTo("france"))
						.body("courses[0]",equalTo("c"))
						.body("courses[1]",equalTo("java"))
						//.header("Content-Type", "application/json; charset=utf-8")
						.log().all();
					
					
				}
				
				//@Test(priority=2)
				public void deleteextjson()
				{
					given()
					
					.when()
						.delete("http://localhost:3000/students/cbe1")
					.then()
						.statusCode(200)
						.log().all();
					
					
				}
				
				
}
