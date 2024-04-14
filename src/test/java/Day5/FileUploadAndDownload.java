package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {
	
	@Test
	public void singleFileUpload()
	{
	
		File myfile=new File("C:\\API\\Automationpractise\\Files\\Test1.txt");
		
		given()
			.multiPart("file", myfile)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/Uploadfile")
		.then()
			.statusCode(200)
			.body("filename", equalTo("Test1.txt"))
			.log().all();
		
		
	}
	
	@Test
	public void multipleFileUpload()
	{
	
		File myfile1=new File("C:\\API\\Automationpractise\\Files\\Test1.txt");
		File myfile2=new File("C:\\API\\Automationpractise\\Files\\Test2.txt");
		
		//File filarr[]={myfile1, myfile2};   // this may not work for all api
		
		given()
			.multiPart("files", myfile1)
			.multiPart("files", myfile2)
			//.multiPart("files", filarr)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/Uploadfile")
		.then()
			.statusCode(200)
			.body("filename", equalTo("Test1.txt"))
			.log().all();
		
		
	}

	@Test
	public void singleFileDownload()
	{
	
		File myfile1=new File("C:\\API\\Automationpractise\\Files\\Test1.txt");
		File myfile2=new File("C:\\API\\Automationpractise\\Files\\Test2.txt");
		
		//File filarr[]={myfile1, myfile2};   // this may not work for all api
		
		given()
			
		.when()
			.get("http://localhost:8080/downloadfile/Test1.txt")
		.then()
			.statusCode(200)
			.log().body();		
		
	}
}
