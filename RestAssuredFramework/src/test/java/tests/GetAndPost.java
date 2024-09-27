package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.shaded.com.google.gson.JsonObject;

public class GetAndPost {
	
	@Test
	public void testGet() {
		
		given().
        get("https://reqres.in/api/users?page=2").
    then().
        statusCode(200).
        body("data[4].first_name", equalTo("George"));  // Corrected the JSON path and matcher
       // body("data.first_name", hashCode ());  // Corrected the JSON path and matcher

        }
	
	@Test
	public void testPost() {
		
		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("name", "abhi");
//		map.put("job", "teacher");
//		System.out.println(map);
		
		JsonObject req=new JsonObject();
		req.addProperty("name", "ujo");
		System.out.println(req.toString());
		
		//given().get("https://reqres.in/api/users?page=2").When().post("/users").then().s 
	}

}
