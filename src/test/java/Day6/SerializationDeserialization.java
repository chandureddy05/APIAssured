package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SerializationDeserialization {
	
	@Test
	public void pojoJSON() throws JsonProcessingException
	{
		
		//create pojo object		
		students data=new students();
		
		data.setName("scott");
		data.setLocation("france");		
		String coursesarr[]={"c","java"};
		data.setCourses(coursesarr);
		
		//convert pojo object to json object		
		ObjectMapper objMap=new ObjectMapper();  //import jackson 
		
		String jsondata=objMap.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		
		System.out.println(jsondata);
		
	}
	
	
	@Test
	public void jsonPOJO() throws JsonProcessingException
	{
		
		//crate json object
		
		String jsondata = "{\r\n"
						+"  \"name\" : \"scott\",\r\n"
						+"  \"location\" : \"france\",\r\n"
						+" \"courses\" : [ \"c\", \"java\" ]\r\n"
						+ "}";
				
		//convert json to pojo
	ObjectMapper objMap=new ObjectMapper();  //import jackson 
	
	students stu=objMap.readValue(jsondata, students.class);
	
	
	System.out.println(stu.getName());
	System.out.println(stu.getLocation());
	System.out.println(stu.getCourses()[0]);
	System.out.println(stu.getCourses()[1]);
	
	
	}

}
